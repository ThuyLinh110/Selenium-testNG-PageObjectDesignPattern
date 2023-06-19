package com.railway.test.Login;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C19_LoginWithAccountThatNotExisted extends BaseTest {
    @Test
    public void c19_LoginWithAccountThatNotExisted() {

        homePage.clickTab("Login");
        loginPage.login(userName,password);

        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);

        homePage.checkTabNotDisplay("My ticket");
        homePage.checkTabNotDisplay("Change password");
        homePage.checkTabNotDisplay("Log out");

        homePage.checkTabDisplay("Login");
        homePage.checkTabDisplay("Register");

        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);
        Assert.assertEquals(loginPage.getWelcomeMessage(), getExpectedWelcomeMsg );

    }


    String password ="1234567890";
    String userName ="invalidEmail@gmail.com";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg = "Invalid username or password. Please try again.";
    String getExpectedWelcomeMsg = "Welcome guest";

}
