package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C8_RegisterAccountFailedWithInvalidFormatEmail extends BaseTest {
    @Test(description = "TC 8 - Verify user can not register account with invalid format email")
    public void c8_RegisterAccountFailedWithInvalidFormatEmail() {

        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register account with invalid format email");
        registerPage.register(invalidUserName, password, password,PID);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the Email error message displays beside the Email field");
        Assert.assertEquals(registerPage.getLabelErrorEmail(), expectedEmailMsg);


    }

    String invalidUserName ="abcd1234";
    String password = "1234566789";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedEmailMsg = "Invalid email address";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
