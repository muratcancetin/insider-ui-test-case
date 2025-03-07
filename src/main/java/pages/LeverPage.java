package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ElementHelper;

public class LeverPage extends BasePage {

    ElementHelper helper;

    public LeverPage(WebDriver driver) {
        super(driver);
        this.helper = getElementHelper();
    }

    @FindBy(xpath = "//a[text()='View Role'][1]")
    WebElement viewRoleButton;

    @FindBy(css = ".position-list-item-wrapper:nth-child(1)")
    WebElement jobRoleCard;

    @FindBy(css = ".position-title:nth-child(1)")
    WebElement jobRoleCardTitle;

    @FindBy(css = ".posting-headline h2")
    WebElement selectedJobTitle;

    public String hoverJobCardAndClickViewRole() {
        helper.scrollToElement(jobRoleCard);
        helper.hoverToElement(jobRoleCard);
        helper.clickElement(viewRoleButton);
        return jobRoleCardTitle.getText();
    }

    public String switchTabAndVerify() {
        helper.switchTab();
        return selectedJobTitle.getText();
    }
}
