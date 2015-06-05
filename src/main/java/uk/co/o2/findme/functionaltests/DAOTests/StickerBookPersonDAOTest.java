package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.PersonLoginDAO;
import uk.co.o2.findme.dao.StickerBookPersonDAO;

public class StickerBookPersonDAOTest {

    StickerBookPersonDAO personLoginDAO = new StickerBookPersonDAO(0, "Boris", "Yeltsin", "http://google.co.uk/image");

    @Test
    public void testStickerBookPersonDAO() {
        Assert.assertEquals(0, personLoginDAO.getPersonId());
        Assert.assertEquals("Boris", personLoginDAO.getFirstName());
        Assert.assertEquals("Yeltsin", personLoginDAO.getLastName());
        Assert.assertEquals("http://google.co.uk/image", personLoginDAO.getPicture());
    }

}