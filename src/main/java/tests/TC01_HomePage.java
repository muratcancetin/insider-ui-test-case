package tests;

import enums.TitleList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ElementHelper;
import utils.Hooks;

import java.io.IOException;

import static utils.ConfigReader.getProperty;

public class TC01_HomePage extends Hooks {
    HomePage homePage;
    ElementHelper helper;

    @BeforeMethod
    public void setUpTest() throws IOException {
        setUp();
        helper = new ElementHelper(driver);
        homePage = new HomePage(driver);
    }


    @Test(priority = 1)
    public void verifyHomePage() {
        driver.get(getProperty("BASE_URL"));
        Assert.assertEquals(driver.getCurrentUrl(),getProperty("BASE_URL"));
        Assert.assertEquals(driver.getTitle(),TitleList.valueOf("HOMEPAGE_TITLE").getTitle);
    }

    @Test
    public void goHomePage() {
        homePage.hoverAndClickToCareersMenu();
        Assert.assertEquals(driver.getCurrentUrl(),getProperty("CAREER_PATH_URL"));
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("CAREERS_TITLE").getTitle);
    }
}
