package Railway;

import Common.Utilities;
import Common.ExcelUtils;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {



    @Test
    public void TC01() {
        System.out.println("TC01- User can login with valid account ");
        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String expectedMsg = "Welcome " + Constant.USERNAME;
        String actualMsg = loginPage.getWelcomeMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected ");
    }

    @Test
    public void TC02() {
        System.out.println("TC02- User cannot login with invalid password");
        // Access excel file
        ExcelUtils invalidPass = new ExcelUtils();
        invalidPass.setExcelFile(Constant.Path_InvalidPassword, "Sheet1");
        int numRow = invalidPass.getNumRow();

        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "Invalid username or password. Please try again.";
        String actualMsg = "";

        for (int i = 1; i <= numRow; i++) {
            loginPage.login(Constant.USERNAME, invalidPass.getCellData(i, 0));
            actualMsg = loginPage.getMessageError();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected ");
        }
    }

    @Test
    public void TC03() {
        System.out.println("TC03- User cannot login with email that haven't already existed");
        // Access excel file
        ExcelUtils notExistedEmail = new ExcelUtils();
        notExistedEmail.setExcelFile(Constant.Path_NotExistedEmail, "Sheet1");
        int numRow = notExistedEmail.getNumRow();

        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "Invalid username or password. Please try again.";
        String actualMsg = "";

        for (int i = 1; i <= numRow; i++) {
            loginPage.login(notExistedEmail.getCellData(i, 0), Constant.PASSWORD);
            actualMsg = loginPage.getMessageError();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected ");
        }
    }
    @Test
    public void TC04() {
        System.out.println("TC04- User cannot login with blank email ");
        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.login("", Constant.PASSWORD);
        String expectedMsgError = "There was a problem with your login and/or errors exist in your form." ;
        String expectedMsgUsername = "You must specify a username.";
        String actualMsgError = loginPage.getMessageError();
        String actualMsgUsername = loginPage.getMessageErrorUserName();
        Assert.assertEquals(expectedMsgError,actualMsgError, "Error message is not displayed as expected ");
        Assert.assertEquals(expectedMsgUsername,actualMsgUsername, "Error message beside Username textbox is not displayed as expected ");

    }
    @Test
    public void TC05() {
        System.out.println("TC05- User cannot login with blank password ");
        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, "");
        String expectedMsgError = "There was a problem with your login and/or errors exist in your form." ;
        String expectedMsgPassword = "You must specify a password.";
        String actualMsgError = loginPage.getMessageError();
        String actualMsgPassword = loginPage.getMessageErrorPassword();
        Assert.assertEquals(expectedMsgError,actualMsgError, "Error message is not displayed as expected ");
        Assert.assertEquals(expectedMsgPassword,actualMsgPassword, "Error message beside Username textbox is not displayed as expected ");

    }




}
