package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends ParentPage {
    @FindBy(xpath=".//*[text()='Elements']")
    private WebElement elements;

    public ElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "elements";
    }

    public ElementsPage checkIsRedirectOnElementsPage() {
        checkUrl();
        return this;
    }

    public void openWebSite() {
        try {
            webdriver.get(baseUrl);
            scrolltoElement(elements);
            clickOnElement(elements);
            logger.info("Website has been opened");
        } catch (Exception e) {
            logger.error("Can not work with web page " + e);
            Assert.fail("Can not work with web page " + e);
        }
    }
}
