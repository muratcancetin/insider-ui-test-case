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

    @FindBy(xpath = "//a[text()='See all QA jobs']")
    private WebElement seeQAJobsButton;

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement filterByLocationDropdown;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement filterByDepartmentDropdown;

    @FindBy(xpath = "//a[contains(text(), 'Decline All')]")
    private WebElement cookieDeclineButton;

    public void openJobsPage() {
        helper.clickElement(cookieDeclineButton);
        helper.clickElement(seeQAJobsButton);
    }

    public void filterByLocationAndDepartment(String location, String department){
        helper.waitFor(3);
        helper.selectDropDownText(filterByLocationDropdown,location);
        helper.selectDropDownText(filterByDepartmentDropdown,department);
    }

}
