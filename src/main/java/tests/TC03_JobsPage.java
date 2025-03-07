package tests;

import enums.TitleList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.JobPages;
import pages.LeverPage;
import utils.ElementHelper;
import utils.Hooks;

import java.io.IOException;

import static utils.ConfigReader.getProperty;

public class TC03_JobsPage extends Hooks {

    JobPages jobPages;
    HomePage homePage;
    CareersPage careersPage;
    LeverPage leverPage;
    ElementHelper helper;

    @BeforeMethod
    public void setUpTest() throws IOException {
        setUp();
        helper = new ElementHelper(driver);
        homePage = new HomePage(driver);
        jobPages = new JobPages(driver);
        careersPage = new CareersPage(driver);
        leverPage = new LeverPage(driver);
    }

    @Test
    public void goToJobsPageAndVerify() {
        helper.goToURL(getProperty("CAREERS_JOB_URL"));
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("QUALITY_ASSURANCE_JOB_OPPORTUNITIES_TITLE").getTitle);
        Assert.assertEquals(driver.getCurrentUrl(), getProperty("CAREERS_JOB_URL"));
    }

    @Test
    public void clickAndVerifyQAJobs() {
        goToJobsPageAndVerify();
        jobPages.openJobsPage();
        Assert.assertEquals(driver.getTitle(), TitleList.valueOf("OPEN_POSITIONS").getTitle);
    }

    @Test
    public void checkThatPositionAndDepartment() {
        clickAndVerifyQAJobs();
        jobPages.filterByLocationAndDepartment("Istanbul, Turkiye", "Quality Assurance");
    }

    @Test
    public void test1() {
        checkThatPositionAndDepartment();
        String titleJobText = leverPage.hoverJobCardAndClickViewRole();
        String switchTabJobText = leverPage.switchTabAndVerify();
        Assert.assertEquals(titleJobText, switchTabJobText);
    }
}
