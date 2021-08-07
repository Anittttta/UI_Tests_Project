package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends ParentPage {
    @FindBy(xpath=".//*[text()='Elements']")
    private WebElement buttonElements;

    @FindBy (xpath=".//*[@class='element-list collapse show']")
    private WebElement listCollapseShow;

    @FindBy (xpath=".//*[text()='Text Box']")
    private WebElement buttonTextBox;

    @FindBy (xpath = ".//input[@id='userName']")
    private WebElement inputUserName;

    


    public TextBoxPage(WebDriver webDriver) {
        super(webDriver);
    }
}
