package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


public class Hooks {
    protected WebDriver driver;
    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/FailedScenarioScreenshoots";

    @BeforeSuite
    public void setUp() throws IOException {
        cleanScreenshotFolder();
        driver = DriverManager.getDriver();
    }

    @BeforeSuite
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
                System.out.println("HataliEkranGoruntuleri klasörü temizlendi.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
