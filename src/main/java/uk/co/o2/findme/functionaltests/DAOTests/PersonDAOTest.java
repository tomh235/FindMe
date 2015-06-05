package uk.co.o2.findme.functionaltests.DAOTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.o2.findme.dao.PersonDAO;

import static java.util.UUID.randomUUID;

public class PersonDAOTest {

    private final String newPersonId = randomUUID().toString();

    PersonDAO personObject = new PersonDAO(
            newPersonId,
            "Boris", "Yeltsin",
            "http://google.co.uk/image",
            "boris.yeltsin@o2.com",
            "+44",
            "07725234398",
            "Developer",
            "Blah Blah Blah",
            "Clarity",
            "Bath Road, Slough",
            "Resourcing & Finance",
            "Active");

    @Test
    public void testPersonDAOObject() {
        Assert.assertEquals(newPersonId, personObject.getPersonId());
        Assert.assertEquals("Boris", personObject.getFirstName());
        Assert.assertEquals("Yeltsin", personObject.getLastName());
        Assert.assertEquals("boris.yeltsin@o2.com", personObject.getEmail());
        Assert.assertEquals("+44", personObject.getAreaCode());
        Assert.assertEquals("07725234398", personObject.getPhoneNumber());
        Assert.assertEquals("Developer", personObject.getJobTitle());
        Assert.assertEquals("Blah Blah Blah", personObject.getDetails());
        Assert.assertEquals("Clarity", personObject.getCurrentProject());
        Assert.assertEquals("Bath Road, Slough", personObject.getLocation());
        Assert.assertEquals("Resourcing & Finance", personObject.getTeamName());
        Assert.assertEquals("Active", personObject.getStatusInTeam());
    }

}