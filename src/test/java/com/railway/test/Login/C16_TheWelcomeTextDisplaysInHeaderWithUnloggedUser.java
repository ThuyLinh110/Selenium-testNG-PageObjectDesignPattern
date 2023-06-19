package com.railway.test.Login;

import com.railway.pageObjects.HomePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C16_TheWelcomeTextDisplaysInHeaderWithUnloggedUser extends BaseTest {
    @Test
    public void c16_TheWelcomeGuestTextDisplaysInHeaderWithUnloggedUser() {

        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome guest!");

    }
    HomePage homePage = new HomePage();
}
