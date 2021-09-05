package elementsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class TextBoxTest extends BaseTest {
    String userName = "John Smith";
    String userEmail = "test@gmail.com";
    String currentAddress = "Kyiv, Ukraine";

    @Test
    public void textBox() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        textBoxPage.clickOnTextBox();
        textBoxPage.checkIsRedirectOnTextBoxPage();
        textBoxPage.fillInputUserName(userName);
        textBoxPage.fillInputUserEmail(userEmail);
        textBoxPage.fillCurrentAddress(currentAddress);
        textBoxPage.scrollToButtonSubmit();
        textBoxPage.clickButtonSubmit();
        textBoxPage.checkTextInOutputName(userName);
        textBoxPage.checkTextInOutputEmail(userEmail);
        textBoxPage.checkTextInOutputCurrentAddress(currentAddress);
    }
}
