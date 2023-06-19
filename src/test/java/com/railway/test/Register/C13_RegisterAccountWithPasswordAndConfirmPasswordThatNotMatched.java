package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C13_RegisterAccountWithPasswordAndConfirmPasswordThatNotMatched extends BaseTest {
    @Test
    public void c13_RegisterAccountWithPasswordAndConfirmPasswordThatNotMatched() {

        homePage.clickTab("Register");
        registerPage.register(userName, password, confirmPassword,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
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
