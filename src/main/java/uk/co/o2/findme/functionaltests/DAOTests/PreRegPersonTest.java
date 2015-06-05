package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.PreRegPerson;

import static java.util.UUID.randomUUID;

public class PreRegPersonTest {

    private final String newPersonId = randomUUID().toString();

    PreRegPerson personObject = new PreRegPerson(
            newPersonId,
            "Boris",
            "Yeltsin",
            "boris.yeltsin@o2.com",
            "http://google.co.uk/image",
            "07725234398",
            "X+olP5mad/g=",
            "CCdAWoRhTBtBirUzDm9/rQ8vEv0=",
            "Developer",
            "Bath Road, Slough",
            "Clarity",
            "Blah Blah Blah",
            "Active",
            "Resourcing & Finance"
            );

    @Test
    public void testPersonDAOObject() {
        Assert.assertEquals(newPersonId, personObject.getPersonId());
        Assert.assertEquals("Boris", personObject.getFirstName());
        Assert.assertEquals("Yeltsin", personObject.getLastName());
        Assert.assertEquals("boris.yeltsin@o2.com", personObject.getEmail());
        Assert.assertEquals("http://google.co.uk/image", personObject.getPhoto());
        Assert.assertEquals("07725234398", personObject.getPhoneNumber());
        Assert.assertEquals("X+olP5mad/g=", personObject.getSalt());
        Assert.assertEquals("CCdAWoRhTBtBirUzDm9/rQ8vEv0=", personObject.getPassword());
        Assert.assertEquals("Developer", personObject.getJobTitle());
        Assert.assertEquals("Bath Road, Slough", personObject.getLocation());
        Assert.assertEquals("Clarity", personObject.getCurrentProject());
        Assert.assertEquals("Blah Blah Blah", personObject.getDetails());
        Assert.assertEquals("Active", personObject.getStatus());
        Assert.assertEquals("Resourcing & Finance", personObject.getTeamName());
    }

}