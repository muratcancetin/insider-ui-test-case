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
        Assert.assertEquals(driver.getCurrentUrl(),getProperty("BASE_URL"));
        Assert.assertEquals(driver.getTitle(),TitleList.valueOf("HOMEPAGE_TITLE").getTitle);
    }

    @Test(dependsOnMethods = "verifyHomePage")
    public void goHomePage() {
        homePage.hoverAndClickToCareersMenu();
        Assert.assertEquals(driver.getCurrentUrl(),getProperty("CAREER_PATH_URL"));
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("CAREERS_TITLE").getTitle);
    }

    @Test
    public void clickAndOpenJobsPage() {
        goHomePage();
        jobPages.openJobsPage();
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("OPEN_POSITION_PAGE_TITLE").getTitle);
    }

}
