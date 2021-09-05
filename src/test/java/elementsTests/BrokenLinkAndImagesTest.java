package elementsTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class BrokenLinkAndImagesTest extends BaseTest {
    String validSiteUrl = "https://demoqa.com/";
    String invalidSiteUrl = "http://the-internet.herokuapp.com/status_codes/500";

    @Test
    public void BrokenAndLinkImages() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        brokenLinksImagesPage.scrollToElementBrokenLinksImages();
        brokenLinksImagesPage.clickOnElementBrokenLinksImages();
        brokenLinksImagesPage.checkIsRedirectOnBrokenPage();
        Assert.assertTrue(brokenLinksImagesPage.isValidImagePresent());
        Assert.assertTrue(brokenLinksImagesPage.isBrokenImagePresent());
        brokenLinksImagesPage.clickValidLink();
        elementsPage.checkLinkUrl(validSiteUrl);
        elementsPage.performBackNavigation();
        brokenLinksImagesPage.checkIsRedirectOnBrokenPage();
        brokenLinksImagesPage.clickBrokenLink();
        elementsPage.checkLinkUrl(invalidSiteUrl);
        elementsPage.performBackNavigation();
        brokenLinksImagesPage.checkIsRedirectOnBrokenPage();
    }
}
