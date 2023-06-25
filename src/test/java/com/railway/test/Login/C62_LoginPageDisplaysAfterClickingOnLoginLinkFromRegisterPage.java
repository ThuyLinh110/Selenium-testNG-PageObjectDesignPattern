package com.railway.test.Login;

import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C62_LoginPageDisplaysAfterClickingOnLoginLinkFromRegisterPage extends BaseTest {

    @Test (description = "TC 15 - Verify Login page displays after clicking on login link from Register page", alwaysRun = true)
    public void c62_LoginPageDisplaysAfterClickingOnLoginLinkFromRegisterPage() {
        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Click on 'login' link");
        registerPage.clickLoginLink();

        Allure.step("Step 2: Verify the Login page displays");
        Assert.assertEquals(loginPage.getNameTitlePage(), "Login Page");
    }

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
}
