package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends ParentPage {
    @FindBy(xpath=".//span[text()='Dynamic Properties']")
    private WebElement elementDynamicProperties;

    @FindBy (xpath=".//button[@id='enableAfter']")
    private WebElement buttonEnableAfter;

    @FindBy (xpath=".//button[@id='colorChange']")
    private WebElement buttonColorChange;

    @FindBy (xpath=".//button[@id='visibleAfter']")
    private WebElement buttonVisibleAfter;

    public DynamicPropertiesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "dynamic-properties";
    }

    public DynamicPropertiesPage checkIsRedirectOnDynamicPropertiesPage() {
        checkUrl();
        return this;
    }
    public void scrollToElementDynamicProperties() {
        scrolltoElement(elementDynamicProperties);
    }

    public DynamicPropertiesPage clickOnElementDynamicProperties() {
        clickOnElement(elementDynamicProperties);
        return this;
    }

    public boolean isButtonEnableAfterPresent() {
        return isElementPresent(buttonEnableAfter);
    }

    public boolean isButtonColorChangePresent() {
        return isElementPresent(buttonColorChange);
    }

    public boolean isButtonVisibleAfterPresent() {
        return isElementPresent(buttonVisibleAfter);
    }

    public DynamicPropertiesPage checkButtonColorChangeColor() {
        checkElementColor(buttonColorChange, "#dc3545", "color");
        return this;
    }
}
