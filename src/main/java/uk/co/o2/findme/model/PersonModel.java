package uk.co.o2.findme.model;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import uk.co.o2.findme.dao.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ee on 13/05/15.
 */
public class PersonModel {

    private PersonsQuery personsQuery = new PersonsQuery();

    private static final String ALGO = "AES";
    private static final byte[] keyValue =
            new byte[] { 'd', 'q', 'h', 'G', 'D', 'x', 'a','j', 'i', 'C', 'l','S', 'Q', 'Z', 'g', 'y' };


    public PersonModel() {

    }

    public PersonDAO getPersonById(String personID) {
        PersonDAO person = personsQuery.searchByPersonIdOf(personID);
        return person;
    }

    public String getStickerBookNumber(String personID) {
        return personsQuery.getNumberOfStickersFor(personID);
    }

    public boolean getIfCompetedFor(String personID) {
        boolean hasPlayed = personsQuery.getIfUserHasPlayedForToday(personID);

        return hasPlayed;
    }

    public String getCompetitionPerson() {
        String personGuess = personsQuery.getPersonStringOfTheDay();
        return personGuess;
    }

    public void addPersonToStickerBook(String currentUser, String targetUser) {
        personsQuery.addPersonToStickerBookFor(currentUser, targetUser);
        personsQuery.updateStickerBookData(currentUser);
    }

    public boolean checkIfConnectionIsAlreadyPresent(String currentUser, String targetUser) {
        int value = personsQuery.checkIfConnectionIsAlreadyPresent(currentUser, targetUser);
        if(value != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<StickerBookPersonDAO> getPeopleInStickerBookFor(String personID) {
        List<StickerBookPersonDAO> list = personsQuery.getAllSBPersonsFor(personID);
        return list;
    }

    public List<GameDataObject> getGameDataLeaderBoards() {
        List<GameDataObject> gameDataLBList = personsQuery.getAllPersonsForGameLeaderBoard();
        return gameDataLBList;
    }

    public List<StickerBookDataObject> getStickerBookLeaderBoards() {
        List<StickerBookDataObject> stickerBookLBList = personsQuery.getAllPersonsForSBLeaderBoard();
        return stickerBookLBList;
    }

    public String submitEntry(String personID, String entry) {
        Date dt = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");

        String currentDate = sdf.format(dt);
        String personGuess = personsQuery.submitEntry(personID, entry);
        System.out.println(personGuess);
        if(personGuess.equals("success")) {
            personsQuery.updateGameData(personID, currentDate);
        }
        return personGuess;
    }

    public boolean isValidPersonID(String personID) {
        boolean response = personsQuery.isValidPersonId(personID);
        return response;
    }

    public String getPersonIdByEmail(String email) {
        String personId = personsQuery.getPersonIdBy(email);
        return personId;
    }

    public String getNumberOfPeopleInDatabase() {
        String number = personsQuery.getCountOfPersonsTable();
        return number;
    }

    public void updatePersonDetails(String personId,
                                       String firstName,
                                       String lastName,
                                       String email,
                                       String phoneNumber,
                                       String picture,
                                       String jobTitle,
                                       String teamName,
                                       String project,
                                       String location,
                                       String details,
                                       String status) {


        personsQuery.updateUser(firstName, lastName, email, phoneNumber, picture, jobTitle, teamName, project, location, details, status, personId);
    }


    public String getEncryptedSessionId(String email) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(email.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        System.out.println(encryptedValue);
        return encryptedValue;
    }

    public static String decryptSessionId(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }


    public SaltAndHashDAO getSaltFor(String email) {
        SaltAndHashDAO saltAndPassword = personsQuery.getPasswordAndSaltFor(email);
        return saltAndPassword;
    }

    public boolean isEmailAddressExistingForLogin(String email) {
        int numberOfPersons = personsQuery.emailMatchCheck(email);
        if(numberOfPersons == 1) {
            return true;
        } else {
            return false;
        }
    }
}
