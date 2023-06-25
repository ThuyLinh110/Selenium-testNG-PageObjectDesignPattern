package com.railway.test.Login;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C19_LoginFailedWithAccountThatNotExisted extends BaseTest {
    @Test(description = "TC 19 - Login failed with account that not existed")
    public void c19_LoginFailedWithAccountThatNotExisted() {
        Allure.step("Step 1: Click Login menu tab");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with the account that not existed");
        loginPage.login(userName,password);

        Allure.step("Step 3: Verify error message displays");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);

        Allure.step("Step 4: Verify My ticket menu tab not displays");
        homePage.checkTabNotDisplay("My ticket");

        Allure.step("Step 5: Verify Change password menu tab not displays");
        homePage.checkTabNotDisplay("Change password");

        Allure.step("Step 6: Verify Log out menu tab not displays");
        homePage.checkTabNotDisplay("Log out");

        Allure.step("Step 7: Verify Login menu tab still displays");
        homePage.checkTabDisplay("Login");

        Allure.step("Step 8: Verify Register menu tab still displays");
        homePage.checkTabDisplay("Register");

    }


    String password ="1234567890";
    String userName ="invalidEmail@gmail.com";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg = "Invalid username or password. Please try again.";
    String getExpectedWelcomeMsg = "Welcome guest";

}
