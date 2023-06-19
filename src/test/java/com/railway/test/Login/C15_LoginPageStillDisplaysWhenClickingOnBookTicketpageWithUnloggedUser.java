package com.railway.test.Login;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C15_LoginPageStillDisplaysWhenClickingOnBookTicketpageWithUnloggedUser extends BasePage {
    @Test
    public void c15_LoginPageStillDisplaysWhenClickingOnBookTicketpageWithUnloggedUser() {

        homePage.clickTab("Book ticket");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Login Page");

    }

    HomePage homePage = new HomePage();
    BookticketPage bookticketPage = new BookticketPage();

}
