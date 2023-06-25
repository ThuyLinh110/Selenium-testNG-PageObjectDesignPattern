package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C66_RegisterAccountFailedWithBlankPasswordField extends BaseTest {
    @Test(description = "TC 66 - Verify user cannot register account with blank password field")
    public void C66_RegisterAccountFailedWithBlankPasswordField() {
        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the blank password");
        registerPage.register(userName, "", confirmPassword,PID);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Verify the Password error message displays beside Password field");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedPasswordMsg, "Message is not displayed as expected");

    }

    String userName ="railwaytest@gmail.com";
    String password = "1234566789";
    String confirmPassword = "1234566789abcd";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedEmailMsg = "Invalid email length";
    String expectedPasswordMsg = "Invalid password length";
    String expectedPIDMsg = "Invalid PID length";
    String expectedConfirmPasswordMsg = "The two passwords do not match";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
