package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C64_RegisterAccountFailedWithPasswordLengthLongerThanAllowed extends BaseTest {

    @Test(description = "TC 64 - Verify user cannot register account with password length is longer than allowed length")
    public void c64_RegisterAccountFailedWithPasswordLengthLongerThanAllowed() {

        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the invalid password");
        registerPage.register(userName, invalidPassword2,invalidPassword2,PID);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the Password error message displays beside Password field");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedPasswordMsg, "Message is not displayed as expected");

    }

    String userName ="abcd@gmail.com";
    String invalidPassword2 = "12345678123456781234567812345678123456781234567812345678123456789";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedPasswordMsg = "Invalid password length";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
