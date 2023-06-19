package com.railway.test.Register;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C5_RegisterPageDisplaysWhenClickingCreateAccountLinkFromHomePage extends BaseTest {
    @Test
    public void c5_RegisterPageDisplaysWhenClickingCreateAccountLinkFromHomePage() {
        homePage.clickOnCreateAccLink();
        Assert.assertEquals(registerPage.getNameTitlePage(), expectedTitle);

    }




    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    String expectedTitle = "Create account";

}
