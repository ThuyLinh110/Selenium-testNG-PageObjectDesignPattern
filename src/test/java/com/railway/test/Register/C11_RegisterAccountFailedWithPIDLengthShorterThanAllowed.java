package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C11_RegisterAccountFailedWithPIDLengthShorterThanAllowed extends BaseTest {
    @Test(description = "TC 11 - Verify user cannot register account with PID length is shorter than allowed length")
    public void c11_RegisterAccountFailedWithPIDLengthShorterThanAllowed() {

        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the invalid PID");
        registerPage.register(userName, password,password,invalidPID1);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the PID error message displays beside PID field");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedPIDMsg, "Message is not displayed as expected");

    }

    String userName ="abcd@gmail.com";
    String password = "123456789";
    String invalidPID1 = "1234567";

    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedPIDMsg = "Invalid ID length";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
