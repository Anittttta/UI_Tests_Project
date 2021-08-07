package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openWebSite() {
        try {
            webdriver.get("https://demoqa.com/elements");
            logger.info("Website has been opened");
        } catch (Exception e) {
            logger.error("Can not work with web page " + e);
            Assert.fail("Can not work with web page " + e);
        }

    }
}
