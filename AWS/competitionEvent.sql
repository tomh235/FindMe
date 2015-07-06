DROP EVENT IF EXISTS `resetCompetition`;
DELIMITER | 
CREATE DEFINER=findme EVENT resetCompetition
ON SCHEDULE EVERY 1 DAY STARTS (TIMESTAMP(CURRENT_DATE) + INTERVAL 17 HOUR)
ON COMPLETION PRESERVE ENABLE DO
BEGIN
		-- Declare variables
			DECLARE previous_person CHAR(36);
			DECLARE previous_person_name VARCHAR(100);
			DECLARE new_person CHAR(36);
 
		-- Get curent competition person and name
			
			SELECT idPerson INTO previous_person FROM persons
            WHERE isDailyPerson = true;
            
            SELECT CONCAT(p.firstName, ' ', p.lastName) INTO previous_person_name FROM persons p
			WHERE p.idPerson=previous_person;
            
		-- Get INT for get person for competition
			SELECT idPerson FROM persons WHERE 1 ORDER BY RAND() LIMIT 1 INTO new_person;
            
        -- Deselect current competition person and set them as bonus person
			UPDATE persons 
            SET isDailyPerson=false, isBonusPerson=true
            WHERE idPerson=previous_person;

		-- Add score to gameData for everyone who got the correct person
			UPDATE gameData g
            JOIN competitionData cd
            ON g.idPerson=cd.idPerson
			SET g.gameScore=g.gameScore+1
            WHERE cd.guess LIKE previous_person_name;
            
		-- Truncate competitionData for new start
			truncate competitionData;
		
        -- Set new person for new game excluding previous_person
			UPDATE persons
            SET isDailyPerson = true
			WHERE idPerson = (
								CASE
									WHEN
										new_person = previous_person
									THEN
										(SELECT idPerson FROM persons WHERE 1 ORDER BY RAND() LIMIT 1)
									ELSE
										new_person
								END
			);
END;
| DELIMITER ;