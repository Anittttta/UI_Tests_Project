package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends ParentPage {
    @FindBy(xpath=".//*[text()='Elements']")
    private WebElement buttonElements;

    @FindBy (xpath=".//*[@class='element-list collapse show']")
    private WebElement listCollapseShow;

    @FindBy (xpath=".//*[@class='element-list collapse']")
    private WebElement listCollapsed;

    @FindBy (xpath=".//span[text()='Text Box']")
    private WebElement buttonTextBox;

    @FindBy (xpath = ".//input[@id='userName']")
    private WebElement inputUserName;

    @FindBy (xpath = ".//input[@id='userEmail']")
    private  WebElement inputUserEmail;

    @FindBy (xpath=".//textarea[@id='currentAddress']")
    private WebElement textAreaCurrentAddress;

    @FindBy (xpath=".//button[@id='submit']")
    private WebElement buttonSubmit;

    @FindBy (xpath=".//*[@id='output']")
    private WebElement textBoxOutput;

    @FindBy (xpath=".//p[@id='currentAddress']")
    private WebElement outputCurrentAddress;

    @FindBy (xpath=".//p[@id='permanentAddress']")
    private WebElement outputPermanentAddress;

    @FindBy (xpath=".//p[@id='name']")
    private WebElement outputName;

    @FindBy (xpath=".//p[@id='email']")
    private  WebElement outputEmail;

    public TextBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "text-box";
    }

    public TextBoxPage checkIsRedirectOnTextBoxPage() {
        checkUrl();
        return this;
    }
    public TextBoxPage clickOnTextBox() {
        clickOnElement(buttonTextBox);
        return this;
    }

    public TextBoxPage fillInputUserName(String userName) {
        enterTextToElement(inputUserName, userName);
        return this;
    }

    public TextBoxPage fillInputUserEmail(String userEmail) {
        enterTextToElement(inputUserEmail, userEmail);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String currentAddress) {
        enterTextToElement(textAreaCurrentAddress, currentAddress);
        return this;
    }

    public TextBoxPage clickButtonSubmit() {
        clickOnElement(buttonSubmit);
        return this;
    }

    public void scrollToButtonSubmit() {
        scrolltoElement(buttonSubmit);
    }

    public TextBoxPage checkTextInOutputName(String text) {
        String actualText = outputName.getText();
        Assert.assertEquals("Message in output name", "Name:"+text, actualText);
        return this;
    }

    public TextBoxPage checkTextInOutputEmail(String text) {
        String actualText = outputEmail.getText();
        Assert.assertEquals("Message in output email", "Email:"+text, actualText);
        return this;
    }

    public TextBoxPage checkTextInOutputCurrentAddress(String text) {
        String actualText = outputCurrentAddress.getText();
        Assert.assertEquals("Message in output Current Address", "Current Address :"+text, actualText);
        return this;
    }

    public TextBoxPage checkTextInOutputPermanentAddress(String text) {
        String actualText = outputPermanentAddress.getText();
        Assert.assertEquals("Message in output name", "Permananet Address :"+text, actualText);
        return this;
    }
}
