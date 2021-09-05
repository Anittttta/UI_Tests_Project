package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    protected ElementsPage elementsPage;
    protected TextBoxPage textBoxPage;
    protected WebTablePage webTablePage;
    protected ButtonsPages buttonsPages;
    protected LinksPage linksPage;
    protected DynamicPropertiesPage dynamicPropertiesPage;
    protected BrokenLinksImagesPage brokenLinksImagesPage;
    protected Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        elementsPage = new ElementsPage(webDriver);
        textBoxPage = new TextBoxPage(webDriver);
        webTablePage = new WebTablePage(webDriver);
        buttonsPages = new ButtonsPages(webDriver);
        linksPage = new LinksPage(webDriver);
        dynamicPropertiesPage = new DynamicPropertiesPage(webDriver);
        brokenLinksImagesPage = new BrokenLinksImagesPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        }

    protected void checkExpectedResult(String message, boolean expectedResult) {
        Assert.assertTrue(message, expectedResult);
    }
}
