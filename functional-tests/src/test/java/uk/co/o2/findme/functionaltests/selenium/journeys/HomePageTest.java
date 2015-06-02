package uk.co.o2.findme.functionaltests.selenium.journeys;

import org.junit.Before;
import org.junit.Test;
import uk.co.o2.findme.functionaltests.selenium.common.SeleniumBase;
import uk.co.o2.findme.functionaltests.selenium.pages.HomePage;
import uk.co.o2.findme.functionaltests.selenium.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HomePageTest extends SeleniumBase {

    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void beforeTest() {
        //TODO Throw error if instantiate page object when browser not there
        homePage = new HomePage();
        homePage.navigateToHomePage();
        loginPage = new LoginPage();
        loginPage.enterLoginDetails();
    }

    @Test
    public void pageElementsExist() {
        assertThat(homePage.hasTitle(), is(true));
        assertThat(homePage.hasNavbar(), is(true));
        assertThat(homePage.hasPeople(), is(true));
        //TODO More comprehensive testing of information displayed
        assertThat(homePage.peopleHaveImages(), is(true));
    }
    //TODO Test page state with no people in DB
    //Given db will return no people
    //When I access the home page
    //Then the message  "There are no faces here!" is displayed

}
