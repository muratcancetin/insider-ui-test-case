package tests;

import enums.TitleList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobPages;
import utils.ElementHelper;
import utils.Hooks;

import java.io.IOException;

import static utils.ConfigReader.getProperty;

public class TC02_CareersPage extends Hooks {
    JobPages jobPages;
    HomePage homePage;
    ElementHelper helper;

    @BeforeMethod
    public void setUpTest() throws IOException {
        setUp();
        helper = new ElementHelper(driver);
        homePage = new HomePage(driver);
        jobPages = new JobPages(driver);
    }

    @Test
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

    @Test
    public void click() {
        goHomePage();
        jobPages.openJobsPage();
    }

}
