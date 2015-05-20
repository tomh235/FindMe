package uk.co.o2.findme.dao;

/**
 * Created by ee on 19/05/15.
 */
public class SaltAndHashDAO {

    private String salt;
    private String passwordHash;

    public SaltAndHashDAO(
        String salt,
        String passwordHash
    ) {
        this.salt = salt;
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
