package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C6_RegisterPageDisplaysWhenClickingOnLinkFromLoginPage extends BaseTest {
    @Test
    public void c6_RegisterPageDisplaysWhenClickingOnLinkFromLoginPage() {
        homePage.clickTab("Login");
        loginPage.navigateRegisterLink();
        Assert.assertEquals(registerPage.getNameTitlePage(), expectedTitle);

    }




    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    String expectedTitle = "Create account";
}
