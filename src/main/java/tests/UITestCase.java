package tests;
import org.testng.annotations.BeforeMethod;
import pages.CareersPage;
import pages.HomePage;
import pages.JobPages;
import pages.LeverPage;
import utils.ElementHelper;
import utils.Hooks;

import java.io.IOException;


public class UITestCase extends Hooks {
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
}
