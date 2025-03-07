package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementHelper;


public class HomePage extends BasePage {

    private ElementHelper helper;


    public HomePage(WebDriver driver) {
        super(driver);
        this.helper = getElementHelper();
    }

    @FindBy(xpath = "//a[contains(text(),'Company')]")
    public static WebElement companyMenu;

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    public static WebElement careersLink;

    public void hoverAndClickToCareersMenu(){
        helper.hoverToElement(companyMenu);
        helper.clickElement(careersLink);
    }

}
