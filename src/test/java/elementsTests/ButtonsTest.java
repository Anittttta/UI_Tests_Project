package elementsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void doubleClick() throws InterruptedException {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        buttonsPages.scrollToElementButtons();
        buttonsPages.clickOnElementButtons();
        buttonsPages.checkIsRedirectOnButtonPage();
        buttonsPages.doubleClickOnButtonDoubleClickMe();
        checkExpectedResult("Message about performed double-click is not present",
                buttonsPages.isDoubleClickMessagePresent());
    }

    @Test
    public void rightClick() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        buttonsPages.scrollToElementButtons();
        buttonsPages.clickOnElementButtons();
        buttonsPages.checkIsRedirectOnButtonPage();
        buttonsPages.rightClickOnButtonRightClickMe();
        checkExpectedResult("Message about performed right-click is not present",
                buttonsPages.isRightClickMessagePresent());
    }

    @Test
    public void dynamicClick() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        buttonsPages.scrollToElementButtons();
        buttonsPages.clickOnElementButtons();
        buttonsPages.checkIsRedirectOnButtonPage();
        buttonsPages.clickOnButtonClickMe();
        checkExpectedResult("Message about performed dynamic click is not present"
                , buttonsPages.isDynamicClickMessagePresent());
    }
}
