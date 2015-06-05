package uk.co.o2.findme.dao;

import uk.co.o2.findme.model.SearchResultsModel;

/**
 * Created by ee on 13/05/15.
 */
public class GameDataObject implements SearchResultsModel {

    // Fields
    private String personId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private int gameScore;


    public GameDataObject(String personId,
                          String firstName,
                          String lastName,
                          String jobTitle,
                          int gameScore
) {

        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.gameScore = gameScore;
    }

    // Getters

    public String getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getGameScore() {
        return gameScore;
    }
}

