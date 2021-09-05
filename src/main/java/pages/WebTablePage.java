package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends  ParentPage {
    @FindBy(xpath = ".//span[text()='Web Tables']")
    private WebElement elementWebTable;

    @FindBy(xpath = ".//img[@id='close_button_svg']")
    private WebElement buttonCloseAd;

    @FindBy(xpath = ".//button[@id='addNewRecordButton']")
    private WebElement buttonAddNewRecord;

    @FindBy(xpath = ".//span[@title='Edit']")
    private WebElement buttonEdit;

    @FindBy(xpath = ".//span[@title='Delete']")
    private WebElement buttonDelete;

    @FindBy(xpath = ".//input[@id='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = ".//input[@id='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = ".//input[@id='userEmail']")
    private WebElement inputUserEmail;

    @FindBy(xpath = ".//input[@id='age']")
    private WebElement inputAge;

    @FindBy(xpath = ".//input[@id='salary']")
    private WebElement inputSalary;

    @FindBy(xpath = ".//input[@id='department']")
    private WebElement inputDepartment;

    @FindBy(xpath = ".//button[@id='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = ".//input[@id='searchBox']")
    private WebElement inputSearch;

    @FindBy(xpath = ".//*[text()='No rows found']")
    private WebElement textNoRowsFound;

    String tableCell = ".//*[@class='rt-tbody']//*[@role='row']//*[text()='%s']";

    public WebTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "webtables";
    }

    public WebTablePage checkIsRedirectOnWebTablePage() {
        checkUrl();
        return this;
    }

    public void scrollToElementWebTable() {
        scrolltoElement(elementWebTable);
    }

    public WebTablePage clickOnElementWebTable() {
        clickOnElement(elementWebTable);
        return this;
    }

    public WebTablePage clickButtonAddNewRecord() {
        clickOnElement(buttonAddNewRecord);
        return this;
    }

    public WebTablePage clickButtonEdit() {
        clickOnElement(buttonEdit);
        return this;
    }

    public WebTablePage clickButtonDelete() {
        clickOnElement(buttonDelete);
        return this;
    }

    public WebTablePage enterFirstName(String firstName) {
        enterTextToElement(inputFirstName, firstName);
        return this;
    }

    public WebTablePage enterLastName(String lastName) {
        enterTextToElement(inputLastName, lastName);
        return this;
    }

    public WebTablePage enterUserEmail(String userEmail) {
        enterTextToElement(inputUserEmail, userEmail);
        return this;
    }

    public WebTablePage enterAge(String age) {
        enterTextToElement(inputAge, age);
        return this;
    }

    public WebTablePage enterSalary(String salary) {
        enterTextToElement(inputSalary, salary);
        return this;
    }

    public WebTablePage enterDepartment(String department) {
        enterTextToElement(inputDepartment, department);
        return this;
    }

    public WebTablePage closeAd() {
        clickOnElement(buttonCloseAd);
        return this;
    }

    public WebTablePage clickButtonSubmit() {
        clickOnElement(buttonSubmit);
        return this;
    }

    public WebTablePage enterSearchQuery(String query) {
        enterTextToElement(inputSearch, query);
        return this;
    }

    public WebTablePage checkTableCell(String input) {
        Assert.assertTrue(isElementPresent(webdriver.findElement(By.xpath((String.format(tableCell, input))))));
        return this;
    }

    public boolean noResultsFound() {
        return isElementPresent(textNoRowsFound);
    }
}
