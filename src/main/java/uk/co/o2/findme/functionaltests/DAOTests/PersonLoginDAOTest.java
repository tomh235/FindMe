package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.PersonLoginDAO;
import uk.co.o2.findme.dao.StickerBookDataObject;

public class PersonLoginDAOTest {

    PersonLoginDAO personLoginDAO = new PersonLoginDAO(0, "boris.yeltsin@o2.com", "X+olP5mad/g=", "CCdAWoRhTBtBirUzDm9/rQ8vEv0=");

    @Test
    public void testPersonLoginDAO() {
        Assert.assertEquals(0, personLoginDAO.getPersonId());
        Assert.assertEquals("boris.yeltsin@o2.com", personLoginDAO.getEmail());
        Assert.assertEquals("X+olP5mad/g=", personLoginDAO.getPersonSalt());
        Assert.assertEquals("CCdAWoRhTBtBirUzDm9/rQ8vEv0=", personLoginDAO.getPersonEncryptedPassword());
    }

}