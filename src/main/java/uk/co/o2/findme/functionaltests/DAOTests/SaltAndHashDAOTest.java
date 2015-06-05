package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.PersonLoginDAO;
import uk.co.o2.findme.dao.SaltAndHashDAO;

public class SaltAndHashDAOTest {

    SaltAndHashDAO personLoginDAO = new SaltAndHashDAO("X+olP5mad/g=", "CCdAWoRhTBtBirUzDm9/rQ8vEv0=");

    @Test
    public void testSaltAndHashDAO() {
        Assert.assertEquals("X+olP5mad/g=", personLoginDAO.getSalt());
        Assert.assertEquals("CCdAWoRhTBtBirUzDm9/rQ8vEv0=", personLoginDAO.getPasswordHash());
    }

}