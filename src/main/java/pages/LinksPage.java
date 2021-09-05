package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksPage extends ParentPage {
    @FindBy(xpath=".//span[text()='Links']")
    private WebElement elementLinks;

    @FindBy (xpath=".//a[@id='simpleLink']")
    private WebElement linkHome;

    @FindBy (xpath=".//a[@id='dynamicLink']")
    private WebElement linkHome4zkGu;

    @FindBy (xpath=".//a[@id='created']")
    private WebElement linkCreated;

    @FindBy (xpath=".//a[@id='no-content']")
    private WebElement linkNoContent;

    @FindBy (xpath=".//a[@id='moved']")
    private WebElement linkMoved;

    @FindBy (xpath=".//a[@id='bad-request']")
    private WebElement linkBadRequest;

    @FindBy (xpath=".//a[@id='unauthorized']")
    private WebElement linkUnauthorized;

    @FindBy (xpath=".//a[@id='forbidden']")
    private WebElement linkForbidden;

    @FindBy (xpath=".//a[@id='invalid-url']")
    private WebElement linkNotFound;

    @FindBy (xpath=".//p[@id='linkResponse']")
    private WebElement linkResponse;

    public LinksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "links";
    }

    public LinksPage checkIsRedirectOnLinksPage() {
        checkUrl();
        return this;
    }
    public void scrollToElementLinks() {
        scrolltoElement(elementLinks);
    }

    public LinksPage clickOnElementLinks() {
        clickOnElement(elementLinks);
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return this;
    }

    public LinksPage clickOnLinkHome() {
        clickOnElement(linkHome);
        return this;
    }

    public void checkUrlInOpenedTabAndCloseTab(String url) {
        List<String> browserTabs = new ArrayList<String>(webdriver.getWindowHandles());
        webdriver.switchTo().window(browserTabs.get(1));
        Assert.assertTrue("Urls are not equal", url.equals(webdriver.getCurrentUrl()));
        webdriver.close();
        webdriver.switchTo().window(browserTabs.get(0));
    }

    public LinksPage clickOnLinkHome4zkGu() {
        clickOnElement(linkHome4zkGu);
        return this;
    }

    public LinksPage clickOnLinkCreated() {
        clickOnElement(linkCreated);
        return this;
    }

    public LinksPage clickOnLinkNoContent() {
        clickOnElement(linkNoContent);
        return this;
    }

    public LinksPage clickOnLinkMoved() {
        scrolltoElement(linkMoved);
        clickOnElement(linkMoved);
        return this;
    }

    public LinksPage clickOnLinkBadRequest() {
        scrolltoElement(linkBadRequest);
        clickOnElement(linkBadRequest);
        return this;
    }

    public LinksPage clickOnLinkForbidden() {
        scrolltoElement(linkForbidden);
        clickOnElement(linkForbidden);
        return this;
    }

    public LinksPage clickOnLinkNotFound() {
        scrolltoElement(linkNotFound);
        clickOnElement(linkNotFound);
        return this;
    }

    public void checkCreatedResponse()  {
        checkTextAfterClickingOnLink(linkResponse, "201", "Created");
    }

    public void checkNoContentResponse() {
        checkTextAfterClickingOnLink(linkResponse, "204", "No Content");
    }

    public void checkMovedResponse()  {
        checkTextAfterClickingOnLink(linkResponse, "301", "Moved Permanently");
    }

    public void checkBadRequestResponse() {
        checkTextAfterClickingOnLink(linkResponse, "400", "Bad Request");
    }


    public void checkForbiddenResponse() {
        checkTextAfterClickingOnLink(linkResponse, "403", "Forbidden");
    }


    public void checkNotFoundResponse() {
        checkTextAfterClickingOnLink(linkResponse, "404", "Not Found");
    }
}
