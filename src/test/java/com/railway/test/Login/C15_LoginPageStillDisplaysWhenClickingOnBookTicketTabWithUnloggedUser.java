package com.railway.test.Login;

import com.railway.pageObjects.*;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C15_LoginPageStillDisplaysWhenClickingOnBookTicketTabWithUnloggedUser extends BaseTest {
    @Test (description = "TC 15 - Verify Login page still displays when clicking on Book Ticket tab with unlogged user", alwaysRun = true)
    public void c15_LoginPageStillDisplaysWhenClickingOnBookTicketTabWithUnloggedUser() {
        Allure.step("Step 1: Navigate to Book ticket page");
        homePage.clickTab("Book ticket");

        Allure.step("Step 2: Verify the Login page still displays");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Login Page");
    }

    HomePage homePage = new HomePage();
    BookticketPage bookticketPage = new BookticketPage();

}
