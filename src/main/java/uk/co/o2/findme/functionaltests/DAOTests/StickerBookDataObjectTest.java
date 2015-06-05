package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.StickerBookDataObject;

public class StickerBookDataObjectTest {

    StickerBookDataObject gameDataObject = new StickerBookDataObject(0, "Boris", "Yeltsin", "Developer", 5);

    @Test
    public void testGameDataObject() {
        System.out.println("Inside testPrintMessage()");
        Assert.assertEquals(0, gameDataObject.getPersonId());
        Assert.assertEquals("Boris", gameDataObject.getFirstName());
        Assert.assertEquals("Yeltsin", gameDataObject.getLastName());
        Assert.assertEquals("Developer", gameDataObject.getJobTitle());
        Assert.assertEquals(5, gameDataObject.getStickerbookScore());
    }

}