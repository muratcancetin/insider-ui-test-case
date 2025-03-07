package tests;

import enums.TitleList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.JobPages;
import utils.ElementHelper;
import utils.Hooks;

import java.io.IOException;

import static utils.ConfigReader.getProperty;

public class TC02_CareersPage extends Hooks {
    JobPages jobPages;
    HomePage homePage;
    CareersPage careersPage;
    ElementHelper helper;

    @BeforeMethod
    public void setUpTest() throws IOException {
        setUp();
        helper = new ElementHelper(driver);
        homePage = new HomePage(driver);
        jobPages = new JobPages(driver);
        careersPage = new CareersPage(driver);
    }

    @Test
    public void verifyHomePage() {
        helper.goToURL(getProperty("BASE_URL"));
        Assert.assertEquals(driver.getCurrentUrl(), getProperty("BASE_URL"));
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("HOMEPAGE_TITLE").getTitle);
    }

    @Test
    public void goCareersPage() {
        verifyHomePage();
        homePage.hoverAndClickToCareersMenu();
        Assert.assertEquals(driver.getCurrentUrl(), getProperty("CAREER_PATH_URL"));
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("CAREERS_TITLE").getTitle);
    }

    @Test
    public void checkAllBlocks() {
        goCareersPage();
        careersPage.clickToSeeAllTeams();
        careersPage.verifyLocations();
        careersPage.verifyLifeAtInsider();
    }
}
