package com.railway.test.Login;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C69_LoginFailedWithBlankPasswordField extends BaseTest {
    @Test(description = "TC 69 - Verify user login failed with blank password field")
    public void c69_LoginFailedWithBlankPasswordField() {
        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with blank email");
        loginPage.login(username,"");

        Allure.step("Step 3: Verify error message displays");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);

        Allure.step("Step 4: Verify password error message displays beside password field");
        Assert.assertEquals(loginPage.getMessageErrorPassword(), expectedPasswordMsg);

        Allure.step("Step 5: Verify My ticket menu tab not displays");
        homePage.checkTabNotDisplay("My ticket");

        Allure.step("Step 6: Verify Change password menu tab not displays");
        homePage.checkTabNotDisplay("Change password");

        Allure.step("Step 7: Verify Log out menu tab not displays");
        homePage.checkTabNotDisplay("Log out");

        Allure.step("Step 8: Verify Login menu tab still displays");
        homePage.checkTabDisplay("Login");

        Allure.step("Step 9: Verify Register menu tab still displays");
        homePage.checkTabDisplay("Register");

    }


    String password ="1234567890";
    String username = "railway@gmail.com";

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
    String expectedPasswordMsg = "You must specify a password.";



}
