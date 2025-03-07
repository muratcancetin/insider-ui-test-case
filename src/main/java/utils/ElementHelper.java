package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    static final Logger logger = LogManager.getLogger(ElementHelper.class);

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // 10 saniye timeout
        this.actions = new Actions(driver);
    }


    public void goToURL(String url) {
        try {
            driver.get(url);
            logger.info("Go To URL Address {}", url);
        } catch (RuntimeException e) {
            logger.error("Not GO URL ", e);
            throw new RuntimeException(e);
        }
    }

    public void hoverToElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            actions.moveToElement(element).build().perform();
            logger.info("Scroll To Element : {}", element);
        } catch (RuntimeException e) {
            logger.error("Not Scroll To Element", e);
            throw new RuntimeException(e);
        }

    }

    public void selectDropDownText(WebElement element, String text) {
        try {
            waitFor(5);
            clickElement(element);
            clickElement(returnVisibleElement(driver.findElement(By.xpath("//li[text()='" + text + "']"))));
            logger.info("Selected Element : {}", text);
        } catch (RuntimeException e) {
            logger.error(" Element is not selected ", e);
            throw new RuntimeException(e);
        }

    }

    public void clickElement(WebElement element) {
        try {
            logger.info("Waiting for element clickable");
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            logger.info("Element clicked.");
        } catch (Exception e) {
            logger.error("Error: Element did not become clickable or click failed.", e);
        }
    }


    public boolean checkElementDisplayed(WebElement element) {
        try {
            logger.info("Displayed Item Successful");
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            logger.error("Error: Element isn't displayed.", e);
            return false;
        }
    }

    public WebElement returnVisibleElement(WebElement element) {
        try {
            logger.info("Displayed Item Successful");
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Error: Element isn't displayed.", e);
            return null;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            actions.moveToElement(returnVisibleElement(element)).build().perform();
            logger.info("Scroll To Element {}", element.getText());
        } catch (Exception e) {
            logger.error("Error: Element isn't displayed.", e);
        }
    }

    public void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds * 1000L);
            logger.info("{} second wait", (milliseconds * 1000L));
        } catch (InterruptedException e) {
            logger.info("Wait Second Error", e);
            throw new RuntimeException("Error " + e.getMessage(), e);
        }
    }

    public void switchTab() {
        try {
            Set<String> windows = driver.getWindowHandles(); //[parentID, childID]
            Iterator<String> it = windows.iterator();
            // parentID
            String parentID = it.next();
            // childID
            String childID = it.next();
            driver.switchTo().window(childID);
            logger.info("Switching Tab ... ");

        } catch (RuntimeException e) {
            logger.error("Windows Tab Not Found : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
