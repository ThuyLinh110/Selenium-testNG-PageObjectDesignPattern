package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C9_RegisterAccountWithInvalidEmailLength extends BaseTest {
    @Test
    public void c9_RegisterAccountWithInvalidEmailLength() {

        // Invalid email (length > 32)
        homePage.clickTab("Register");
        registerPage.register(invalidUserName, password, password,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");
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
