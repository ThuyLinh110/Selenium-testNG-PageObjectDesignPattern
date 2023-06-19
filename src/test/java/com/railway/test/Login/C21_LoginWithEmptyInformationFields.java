package com.railway.test.Login;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C21_LoginWithEmptyInformationFields extends BaseTest {
    @Test
    public void c21_LoginWithEmptyInformationFields() {
        homePage.clickTab("Login");
        loginPage.login("",password);
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);

        homePage.checkTabNotDisplay("My ticket");
        homePage.checkTabNotDisplay("Change password");
        homePage.checkTabNotDisplay("Log out");

        homePage.checkTabDisplay("Login");
        homePage.checkTabDisplay("Register");

        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);
        Assert.assertEquals(loginPage.getWelcomeMessage(), expectedWelcomeMsg );
        Assert.assertEquals(loginPage.getMessageErrorUserName(), expectedEmailMsg);



        homePage.clickTab("Login");
        loginPage.login(username,"");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);

        homePage.checkTabNotDisplay("My ticket");
        homePage.checkTabNotDisplay("Change password");
        homePage.checkTabNotDisplay("Log out");

        homePage.checkTabDisplay("Login");
        homePage.checkTabDisplay("Register");

        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);
        Assert.assertEquals(loginPage.getWelcomeMessage(), expectedWelcomeMsg );
        Assert.assertEquals(loginPage.getMessageErrorPassword(), expectedPasswordMsg);

    }


    String password ="1234567890";
    String username = "railway@gmail.com";

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
    String expectedEmailMsg = "You must specify a username.";
    String expectedPasswordMsg = "You must specify a password.";
    String expectedWelcomeMsg = "Welcome guest";


}
