package com.railway.test.Register;

import com.railway.common.Log;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C10_RegisterAccountWithInvalidPasswordLength extends BaseTest {

    @Test
    public void c10_RegisterAccountWithInvalidPasswordLength() {



        // Register with invalid password (length <8)
        homePage.clickTab("Register");
        registerPage.register(userName, invalidPassword1,invalidPassword1,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedPasswordMsg, "Message is not displayed as expected");

        // Register with invalid password (length >64)
        registerPage.register(userName, invalidPassword2,invalidPassword2,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedPasswordMsg, "Message is not displayed as expected");

    }

    String userName ="abcd@gmail.com";
    String invalidPassword1 = "1234567";
    String invalidPassword2 = "12345678123456781234567812345678123456781234567812345678123456789";
    String PID = "123456789";
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedPasswordMsg = "Invalid password length";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
