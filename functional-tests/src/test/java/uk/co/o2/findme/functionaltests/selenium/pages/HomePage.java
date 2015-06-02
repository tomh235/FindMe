package uk.co.o2.findme.functionaltests.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uk.co.o2.findme.functionaltests.selenium.common.Configuration;
import uk.co.o2.findme.functionaltests.selenium.common.WebBrowser;

import java.util.List;

public class HomePage {

    public void navigateToHomePage() {
        System.out.println(Configuration.baseUrl);
        WebBrowser.navigateTo(Configuration.baseUrl);
     }

    public TeamListPage clickTeamTab() {
        WebBrowser.findElement(By.id("teams")).click();
        return new TeamListPage();
    }

    public SearchPage clickSearchTab() {
        WebBrowser.findElement(By.id("search")).click();
        return new SearchPage();
    }

    public PersonDetailsPage clickPerson(String name) {
        WebBrowser.findElement(By.id(name)).click();
        return new PersonDetailsPage();
    }

    public boolean personExists(String name, String team, String imgUrl) {
        List<WebElement> elements = WebBrowser.findElements(By.className("entry"));

        for (WebElement element: elements) {
            String currentName = element.findElement(By.className("entryName")).getText();
            String currentTeam = element.findElement(By.className("teamName")).getText();
            String currentImgUrl  = element.findElement(By.cssSelector("img")).getAttribute("src");
            if (currentName.equals(name) && currentTeam.equals(team) && currentImgUrl.equals(imgUrl)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTitle() {
        return WebBrowser.findElement(By.id("homeTitle")).isDisplayed();
    }

    public Boolean hasNavbar() {
        return WebBrowser.findElement(By.className("nav")).isDisplayed();
    }

    public Boolean hasPeople() {
        return WebBrowser.findElement(By.className("entry")).isDisplayed();
    }

    public Boolean peopleHaveImages() {
        return WebBrowser.findElement(By.className("avatar")).isDisplayed();
    }

    public Boolean hasFooter() {
        return WebBrowser.findElement(By.className("footer")).isDisplayed();
    }
}
