package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementHelper;

public class JobPages extends BasePage {
    ElementHelper helper;

    public JobPages(WebDriver driver) {
        super(driver);
        this.helper = getElementHelper();
    }

    @FindBy(xpath = "//a[text()='Find your dream job']")
    public static WebElement findYourJobButton;

    public void openJobsPage() {
        helper.clickElement(findYourJobButton);
    }
}
