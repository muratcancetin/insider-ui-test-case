package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.ElementHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CareersPage extends BasePage {

    private ElementHelper helper;
    private static final Logger logger = LoggerFactory.getLogger(CareersPage.class);


    public CareersPage(WebDriver driver) {
        super(driver);
        this.helper = getElementHelper();
    }

    @FindBy(css = ".glide__slides li")
    private List<WebElement> locationsList;

    @FindBy(xpath = "//*[contains(text(), 'Our Locations')]")
    private WebElement ourLocationsBlock;

    @FindBy(xpath = "//a[text()='See all teams']")
    private WebElement seeAllTeamsButton;

    @FindBy(xpath = "//*[text()='Life at Insider']")
    private WebElement lifeAtInsiderText;

    @FindBy(xpath = "//a[contains(text(), 'Decline All')]")
    private WebElement cookieDeclineButton;

    @FindBy(id = "career-find-our-calling")
    private WebElement seeAllTeamsBlocks;


    public void clickToSeeAllTeams() {
        helper.clickElement(cookieDeclineButton);
        helper.scrollToElement(seeAllTeamsButton);
        helper.clickElement(seeAllTeamsButton);
        helper.checkElementDisplayed(seeAllTeamsButton);
    }

    public void verifyLocations() {
        helper.scrollToElement(ourLocationsBlock);
        try {
            List<String> countryNames = locationsList.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            System.out.println("Locations : " + countryNames.size() + " count.");
            Assert.assertEquals(countryNames.size(), 25);
            logger.info("Locations Count Verified");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyLifeAtInsider() {
        helper.scrollToElement(lifeAtInsiderText);
        helper.checkElementDisplayed(lifeAtInsiderText);
        System.out.println("Life at Insider Basligi Dogrulandi.");
    }
}
