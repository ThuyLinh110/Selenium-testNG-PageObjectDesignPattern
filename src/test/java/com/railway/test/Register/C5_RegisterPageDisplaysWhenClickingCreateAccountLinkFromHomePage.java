package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C5_RegisterPageDisplaysWhenClickingCreateAccountLinkFromHomePage extends BaseTest {
    @Test(description = "TC 5 - Verify The Register page displays when clicking on 'Create an account' link from Home page")
    public void c5_RegisterPageDisplaysWhenClickingCreateAccountLinkFromHomePage() {
        Allure.step("Step 1: Click on 'create an account link'");
        homePage.clickOnCreateAccLink();

        Allure.step("Step 2: Verify the Register page displays");
        Assert.assertEquals(registerPage.getNameTitlePage(), expectedTitle);

    }

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    String expectedTitle = "Create account";

}
