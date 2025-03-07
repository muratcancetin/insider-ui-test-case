package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    private static final Logger logger = LoggerFactory.getLogger(ElementHelper.class);

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10 saniye timeout
        this.actions = new Actions(driver);
    }

    public void hoverToElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).build().perform();
    }

    public void clickElement(WebElement element) {
        try {
            logger.info("Bekleniyor: Element tıklanabilir hale gelene kadar bekleniyor.");
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            logger.info("Element tıklandı.");
        } catch (Exception e) {
            logger.error("Error: Element did not become clickable or click failed.", e);
        }
    }

    public void sendKeysElement(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        } catch (Exception e) {
            logger.error("Error: Send Keys to Element failed", e);
        }

    }

    public String getElementText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            logger.info("Displayed Item Successful");
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            logger.error("Error: Element isn't displayed.", e);
            return false;
        }
    }

    public boolean isNonDisplayElement(By element) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            return false;
        }
    }

}
