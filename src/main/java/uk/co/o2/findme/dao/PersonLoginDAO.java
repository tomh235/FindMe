package uk.co.o2.findme.dao;

/**
 * Created by ee on 19/05/15.
 */
public class PersonLoginDAO {

    private String personId;
    private String email;
    private String personSalt;
    private String personEncryptedPassword;

    public PersonLoginDAO(String personId,
                     String email,
                     String personSalt,
                     String personEncryptedPassword) {

        this.personId = personId;
        this.email = email;
        this.personSalt = personSalt;
        this.personEncryptedPassword = personEncryptedPassword;
    }

    public String getPersonId() {
        return personId;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonSalt() {
        return personSalt;
    }

    public String getPersonEncryptedPassword() {
        return personEncryptedPassword;
    }
}

