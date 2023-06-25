package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C6_RegisterPageDisplaysWhenClickingOnLinkFromLoginPage extends BaseTest {
    @Test(description = "TC 6 - Verify The Register page displays when clicking on 'Register Page' link from Login page")
    public void c6_RegisterPageDisplaysWhenClickingOnLinkFromLoginPage() {
        Allure.step("Step 1: Click on Login menu tab");
        homePage.clickTab("Login");

        Allure.step("Step 2: Click on 'Register Page' link");
        loginPage.navigateRegisterLink();

        Allure.step("Step 3: Verify Register page displays");
        Assert.assertEquals(registerPage.getNameTitlePage(), expectedTitle);

    }


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    String expectedTitle = "Create account";
}
