package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;

public class BrokenLinksImagesPage extends ParentPage {
    @FindBy(xpath=".//span[text()='Broken Links - Images']")
    private WebElement elementBrokenLinksImages;

    @FindBy (xpath=".//div[@class='body-height']//img[@src='/images/Toolsqa.jpg']")
    private WebElement validImage;

    @FindBy (xpath=".//img[@src='/images/Toolsqa_1.jpg']")
    private WebElement brokenImage;

    @FindBy (xpath=".//a[@href='http://demoqa.com']")
    private WebElement validLink;

    @FindBy (xpath=".//a[@href='http://the-internet.herokuapp.com/status_codes/500']")
    private WebElement brokenLink;

    public BrokenLinksImagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "broken";
    }

    public BrokenLinksImagesPage checkIsRedirectOnBrokenPage() {
        checkUrl();
        return this;
    }

    public void scrollToElementBrokenLinksImages() {
        scrolltoElement(elementBrokenLinksImages);
    }

    public BrokenLinksImagesPage clickOnElementBrokenLinksImages() {
        clickOnElement(elementBrokenLinksImages);
        return this;
    }

    public boolean isValidImagePresent() {
        return isElementPresent(validImage);
    }

    public boolean isBrokenImagePresent() {
        return isElementPresent(brokenImage);
    }

    public BrokenLinksImagesPage clickValidLink() {
        scrolltoElement(validLink);
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        clickOnElement(validLink);
        return this;
    }

    public BrokenLinksImagesPage clickBrokenLink() {
        scrolltoElement(brokenLink);
        clickOnElement(brokenLink);
        return this;
    }
}
