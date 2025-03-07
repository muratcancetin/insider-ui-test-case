package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    private static final Logger logger = LoggerFactory.getLogger(ElementHelper.class);
    Select select;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // 10 saniye timeout
        this.actions = new Actions(driver);
    }


    public void goToURL(String url) {
        try {
            driver.get(url);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void hoverToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).build().perform();
    }

    public void selectDropDownText(WebElement element, String text) {
        waitFor(5);
        clickElement(element);
        clickElement(returnVisibleElement(driver.findElement(By.xpath("//li[text()='" + text + "']"))));
    }

    public void clickElement(WebElement element) {
        try {
            logger.info("Waiting for element clickable");
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            logger.info("Element tıklandı.");
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
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Bekleme sırasında bir hata oluştu: " + e.getMessage(), e);
        }
    }

    public void switchTab () {
        try {
            Set<String> windows = driver.getWindowHandles(); //[parentID, childID]
            Iterator<String> it = windows.iterator();
            // parentID
            String parentID = it.next();
            // childID
            String childID = it.next();
            driver.switchTo().window(childID);

        } catch (RuntimeException e) {
            throw new RuntimeException("Windows Tab Not Found : " + e.getMessage(), e);
        }
    }
}
