package elementsTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class WebTableTest extends BaseTest {
    private String firstName = "John";
    private String firstNameEdited = "Alex";
    private String lastName = "Smith";
    private String userEmail="john.smith@gmail.com";
    private String age="42";
    private String salary="10000";
    private String department="Marketing";

    @Test
    public void webTable() {
        elementsPage.openWebSite();
        elementsPage.checkIsRedirectOnElementsPage();
        webTablePage.scrollToElementWebTable();
        webTablePage.clickOnElementWebTable();
        webTablePage.checkIsRedirectOnWebTablePage();
        webTablePage.clickButtonAddNewRecord();
        webTablePage.enterFirstName(firstName);
        webTablePage.enterLastName(lastName);
        webTablePage.enterUserEmail(userEmail);
        webTablePage.enterAge(age);
        webTablePage.enterSalary(salary);
        webTablePage.enterDepartment(department);
        webTablePage.clickButtonSubmit();
        webTablePage.enterSearchQuery(firstName);
        webTablePage.checkTableCell(firstName);
        webTablePage.checkTableCell(lastName);
        webTablePage.checkTableCell(userEmail);
        webTablePage.checkTableCell(age);
        webTablePage.checkTableCell(salary);
        webTablePage.checkTableCell(department);
        webTablePage.clickButtonEdit();
        webTablePage.enterFirstName(firstNameEdited);
        webTablePage.clickButtonSubmit();
        webTablePage.enterSearchQuery(firstNameEdited);
        webTablePage.checkTableCell(firstNameEdited);
        webTablePage.clickButtonDelete();
        webTablePage.enterSearchQuery(firstNameEdited);
        Assert.assertTrue(webTablePage.noResultsFound());
    }
}