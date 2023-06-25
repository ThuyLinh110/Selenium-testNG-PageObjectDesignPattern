package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C13_RegisterAccountFailedWithPasswordAndConfirmPasswordThatNotMatched extends BaseTest {
    @Test(description = "TC 13 - Verify user cannot register account with password and confirm password that not matched")
    public void c13_RegisterAccountFailedWithPasswordAndConfirmPasswordThatNotMatched() {
        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the password and confirm password are not matched");
        registerPage.register(userName, password, confirmPassword,PID);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the Confirm Password error message displays beside Confirm Password field");
        Assert.assertEquals(registerPage.getLabelErrorConfirmPassword(), expectedConfirmPasswordMsg, "Message is not displayed as expected");

    }

    String userName ="railwaytest@gmail.com";
    String password = "1234566789";
    String confirmPassword = "1234566789abcd";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedConfirmPasswordMsg = "The two passwords do not match";

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
