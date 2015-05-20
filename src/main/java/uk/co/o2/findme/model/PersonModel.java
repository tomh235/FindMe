package uk.co.o2.findme.model;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.dao.PersonLoginDAO;
import uk.co.o2.findme.dao.SaltAndHashDAO;
import uk.co.o2.findme.dao.StickerBookPersonDAO;
import uk.co.o2.findme.mapper.SearchResultsPersonModelMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ee on 13/05/15.
 */
public class PersonModel {

    PersonsQuery personsQuery = new PersonsQuery();

    public PersonModel() {

    }

    public PersonDAO getPersonById(int personID) {
        PersonDAO person = personsQuery.searchByPersonIdOf(personID);
        return person;
    }

    public SaltAndHashDAO getSaltFor(String email) {
        SaltAndHashDAO saltAndPassword = personsQuery.getPasswordAndSaltFor(email);
        return saltAndPassword;
    }

/*    public boolean checkLoginDetails(String email, String password) {
        PersonLoginDAO person = personsQuery.getLoginDetailsOf(email);


        if(person.getEmail().equals(email) && person.getPersonEncryptedPassword().equals(sDigest)) {
            person = null;
            return true;
        } else {
            person = null;
            return false;
        }
    }*/

    public boolean isEmailAddressExistingForLogin(String email) {
        int numberOfPersons = personsQuery.emailMatchCheck(email);
        if(numberOfPersons == 1) {
            return true;
        } else {
            return false;
        }
    }
}
