package com.railway.test.Login;

import com.railway.pageObjects.HomePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C16_TheWelcomeTextDisplaysInHeaderWithUnloggedUser extends BaseTest {
    @Test (description = "TC 16 - Verify the 'Welcome guest!' text displays with unlogged user", alwaysRun = true)
    @Severity(SeverityLevel.MINOR)
    public void c16_TheWelcomeGuestTextDisplaysInHeaderWithUnloggedUser() {
        Allure.step("Step 1: Verify the 'Welcome guest!' text displays");
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome guest!");
    }
    HomePage homePage = new HomePage();
}
