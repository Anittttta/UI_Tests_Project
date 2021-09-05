package elementsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LinksTest extends BaseTest {
    protected String linkHome = "https://demoqa.com/";
    protected String linkHome4zkGu = "https://demoqa.com/";

    @Test
    public void links() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        linksPage.scrollToElementLinks();
        linksPage.clickOnElementLinks();
        linksPage.checkIsRedirectOnLinksPage();
        linksPage.clickOnLinkHome();
        linksPage.checkUrlInOpenedTabAndCloseTab(linkHome);
        linksPage.clickOnLinkHome4zkGu();
        linksPage.checkUrlInOpenedTabAndCloseTab(linkHome4zkGu);
        linksPage.clickOnLinkCreated();
        linksPage.checkCreatedResponse();
        linksPage.clickOnLinkNoContent();
        linksPage.checkNoContentResponse();
        linksPage.clickOnLinkMoved();
        linksPage.checkMovedResponse();
        linksPage.clickOnLinkBadRequest();
        linksPage.checkBadRequestResponse();
        linksPage.clickOnLinkForbidden();
        linksPage.checkForbiddenResponse();
        linksPage.clickOnLinkNotFound();
        linksPage.checkNotFoundResponse();
    }
}
