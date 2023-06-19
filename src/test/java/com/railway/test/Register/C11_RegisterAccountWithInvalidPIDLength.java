package com.railway.test.Register;

import com.railway.common.Log;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C11_RegisterAccountWithInvalidPIDLength extends BaseTest {
    @Test
    public void c11_RegisterAccountWithInvalidPIDLength() {



        // Register with invalid PID (length <8)
        homePage.clickTab("Register");
        registerPage.register(userName, password,password,invalidPID1);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedPIDMsg, "Message is not displayed as expected");

        // Register with invalid PID (length >20)
        registerPage.register(userName, password, password, invalidPID2);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedPIDMsg, "Message is not displayed as expected");

    }

    String userName ="abcd@gmail.com";
    String password = "123456789";
    String invalidPID1 = "1234567";
    String invalidPID2 = "123456789012345678901";

    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    String expectedPIDMsg = "Invalid ID length";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
