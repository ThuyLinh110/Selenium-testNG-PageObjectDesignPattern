package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C63_RegisterAccountFailedWithEmailLengthLongerThanAllowed extends BaseTest {
    @Test(description = "TC 63 - Verify user cannot register account with email length is longer than allowed length")
    public void c63_RegisterAccountFailedWithEmailLengthLongerThanAllowed() {

        // Invalid email (length > 32)
        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the invalid email");
        registerPage.register(invalidUserName, password, password,PID);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the Email error message displays beside Email field");
        Assert.assertEquals(registerPage.getLabelErrorEmail(), expectedEmailMsg);
    }

    String invalidUserName ="railwaytest123456789abcdefgh123456@gmail.com";
    String password = "1234566789";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedEmailMsg = "Invalid email length";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

}
