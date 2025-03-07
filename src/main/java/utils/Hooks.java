package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


public class Hooks {
    protected WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/FailedScenarioScreenshoots";

    @BeforeSuite
    public void setUp() throws IOException {
        cleanScreenshotFolder();
        driver = DriverManager.getDriver();
    }

    @AfterSuite
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(SCREENSHOT_FOLDER + "/" + result.getName() + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverManager.quitDriver();
    }

    private void cleanScreenshotFolder() {
        File folder = new File(SCREENSHOT_FOLDER);
        if (folder.exists() && folder.isDirectory()) {
            try {
                FileUtils.cleanDirectory(folder);
                logger.info("Failed Scenario Folder cleared ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
