package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.PersonLoginDAO;
import uk.co.o2.findme.dao.StickerBookPersonDAO;

import static java.util.UUID.randomUUID;

public class StickerBookPersonDAOTest {

    private final String newPersonId = randomUUID().toString();
    StickerBookPersonDAO personLoginDAO = new StickerBookPersonDAO(newPersonId, "Boris", "Yeltsin", "http://google.co.uk/image");

    @Test
    public void testStickerBookPersonDAO() {
        Assert.assertEquals(newPersonId, personLoginDAO.getPersonId());
        Assert.assertEquals("Boris", personLoginDAO.getFirstName());
        Assert.assertEquals("Yeltsin", personLoginDAO.getLastName());
        Assert.assertEquals("http://google.co.uk/image", personLoginDAO.getPicture());
    }

}