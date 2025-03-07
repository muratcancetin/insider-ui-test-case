package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementHelper;

public class CareersPage extends BasePage{

    private ElementHelper helper;

    public CareersPage(WebDriver driver) {
        super(driver);
        this.helper = getElementHelper();
    }

    @FindBy(xpath = "//div[contains(@class, 'locations')]")
    private WebElement locationsBlock;

    @FindBy(xpath = "//div[contains(@class, 'teams')]")
    private WebElement teamsBlock;

    @FindBy(xpath = "//div[contains(@class, 'life-at-insider')]")
    private WebElement lifeAtInsiderBlock;
}
