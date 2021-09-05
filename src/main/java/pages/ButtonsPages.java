package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPages extends ParentPage {
    @FindBy (xpath=".//span[text()='Buttons']")
    private WebElement elementButtons;

    @FindBy (xpath=".//button[@id='doubleClickBtn']")
    private WebElement buttonDoubleClickMe;

    @FindBy (xpath=".//button[@id='rightClickBtn']")
    private WebElement buttonRightClickMe;

    @FindBy (xpath=".//button[text()='Click Me']")
    private WebElement buttonClickMe;

    @FindBy (xpath=".//p[@id='doubleClickMessage']")
    private WebElement messageDoubleClick;

    @FindBy (xpath=".//p[@id='rightClickMessage']")
    private WebElement messageRightClick;

    @FindBy (xpath=".//p[@id='dynamicClickMessage']")
    private WebElement messageDynamicClick;

    public ButtonsPages(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "buttons";
    }

    public ButtonsPages checkIsRedirectOnButtonPage() {
        checkUrl();
        return this;
    }
    public void scrollToElementButtons() {
        scrolltoElement(elementButtons);
    }

    public ButtonsPages clickOnElementButtons() {
        clickOnElement(elementButtons);
        return this;
    }

    public ButtonsPages doubleClickOnButtonDoubleClickMe() throws InterruptedException {
        webDriverWait15.until(ExpectedConditions.elementToBeClickable(buttonDoubleClickMe));
        doubleClickOnElement(buttonDoubleClickMe);
        return this;
    }

    public ButtonsPages rightClickOnButtonRightClickMe() {
        rightClickOnElement(buttonRightClickMe);
        return this;
    }

    public ButtonsPages clickOnButtonClickMe() {
        clickOnElement(buttonClickMe);
        return this;
    }

    public boolean isDoubleClickMessagePresent() {
        return isElementPresent(messageDoubleClick);
    }

    public boolean isRightClickMessagePresent() {
        return isElementPresent(messageRightClick);
    }

    public boolean isDynamicClickMessagePresent() {
        return isElementPresent(messageDynamicClick);
    }
}
