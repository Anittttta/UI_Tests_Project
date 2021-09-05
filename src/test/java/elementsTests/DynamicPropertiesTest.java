package elementsTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void dynamicProperties() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        dynamicPropertiesPage.scrollToElementDynamicProperties();
        dynamicPropertiesPage.clickOnElementDynamicProperties();
        dynamicPropertiesPage.checkIsRedirectOnDynamicPropertiesPage();
        Assert.assertTrue(dynamicPropertiesPage.isButtonEnableAfterPresent());
        Assert.assertTrue(dynamicPropertiesPage.isButtonColorChangePresent());
        Assert.assertTrue(dynamicPropertiesPage.isButtonVisibleAfterPresent());
        dynamicPropertiesPage.checkButtonColorChangeColor();
    }
}
