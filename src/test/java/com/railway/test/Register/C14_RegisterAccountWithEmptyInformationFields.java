package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C14_RegisterAccountWithEmptyInformationFields extends BaseTest {
    @Test
    public void c14_RegisterAccountWithEmptyInformationFields() {

        homePage.clickTab("Register");
        registerPage.register("", password, confirmPassword,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorEmail(), expectedEmailMsg, "Message is not displayed as expected");

        registerPage.register(userName, "", confirmPassword,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedPasswordMsg, "Message is not displayed as expected");

        registerPage.register(userName, password, "",PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorConfirmPassword(), expectedConfirmPasswordMsg, "Message is not displayed as expected");

        registerPage.register(userName, password, confirmPassword,"");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedPIDMsg, "Message is not displayed as expected");

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
