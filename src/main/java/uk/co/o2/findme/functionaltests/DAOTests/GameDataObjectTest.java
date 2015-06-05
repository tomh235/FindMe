package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.GameDataObject;

import static java.util.UUID.randomUUID;
import static org.testng.Assert.*;

public class GameDataObjectTest {

    private final String newPersonId = randomUUID().toString();
    GameDataObject gameDataObject = new GameDataObject(newPersonId, "Boris", "Yeltsin", "Developer", 5);

    @Test
    public void testGameDataObject() {
        System.out.println("Inside testPrintMessage()");
        Assert.assertEquals(newPersonId, gameDataObject.getPersonId());
        Assert.assertEquals("Boris", gameDataObject.getFirstName());
        Assert.assertEquals("Yeltsin", gameDataObject.getLastName());
        Assert.assertEquals("Developer", gameDataObject.getJobTitle());
        Assert.assertEquals(5, gameDataObject.getGameScore());
    }

}