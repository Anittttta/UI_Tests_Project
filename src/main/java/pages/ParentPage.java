package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public abstract class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webdriver;
    WebDriverWait webDriverWait10, webDriverWait15;
    public static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    protected final String baseUrl = configProperties.base_url();

    public ParentPage(WebDriver webDriver) {
        this.webdriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, configProperties.TIME_FOR_DFFAULT_WAIT());
        webDriverWait15 = new WebDriverWait(webDriver, configProperties.TIME_FOR_EXPLICIT_WAIT_LOW());
    }

    abstract String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid page "
                , baseUrl + getRelativeUrl()
                , webdriver.getCurrentUrl()
        );
    }

    protected void enterTextToElement(WebElement webElement, String text) {
        try{
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("'" + text + "' was inputted in element");
        } catch (Exception e){
            writeErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element has been clicked");
        } catch(Exception e) {
            writeErrorAndStopTest(e);
        }
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void doubleClickOnElement(WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            Actions actions = new Actions(webdriver);
            actions.doubleClick(webElement).perform();
            logger.info("Element has been clicked");
        } catch(Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    protected void rightClickOnElement(WebElement webElement) {
        Actions actions = new Actions(webdriver);
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            actions.contextClick(webElement).perform();
            logger.info("Element has been clicked");
        } catch(Exception e) {
            writeErrorAndStopTest(e);
        }
    }

    protected boolean isElementPresent(WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element is present");
            } else {
                logger.info("Element is not present");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not present");
            return false;
        }
    }

    public void checkTextAfterClickingOnLink(WebElement webElement, String status, String statusText) {
        String expectedTextInResponse = "Link has responded with staus " + status + " and status text " + statusText;
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals("Message in textInResponse", expectedTextInResponse, webElement.getText());
    }

    public void scrolltoElement(WebElement element) {
        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void checkLinkUrl(String url) {
        Assert.assertTrue("Urls are not equal", url.equals(webdriver.getCurrentUrl()));
    }

    public void performBackNavigation() {
        webdriver.navigate().back();
    }

    public void checkElementColor(WebElement webElement, String expectedHexColor, String cssValue) {
        String actualColorCode = webElement.getCssValue(cssValue);
        String actualHexaColor = Color.fromString(actualColorCode).asHex();
        Assert.assertEquals(expectedHexColor, actualHexaColor);
    }

    private void writeErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
