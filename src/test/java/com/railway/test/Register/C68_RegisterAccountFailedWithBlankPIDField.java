package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C68_RegisterAccountFailedWithBlankPIDField extends BaseTest {
    @Test(description = "TC 68 - Verify user cannot register account with blank PID field")
    public void c68_RegisterAccountFailedWithBlankPIDField() {
        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the blank PID");
        registerPage.register(userName, password, confirmPassword,"");

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the PID error message displays beside PID field");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedPIDMsg, "Message is not displayed as expected");

    }

    String userName ="railwaytest@gmail.com";
    String password = "1234566789";
    String confirmPassword = "1234566789abcd";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedPIDMsg = "Invalid ID length";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
