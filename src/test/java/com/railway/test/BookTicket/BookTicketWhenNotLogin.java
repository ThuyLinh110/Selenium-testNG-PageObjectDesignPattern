package com.railway.test.BookTicket;

import com.railway.common.Log;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketWhenNotLogin extends BaseTest {
    @Test
    public void TC04() {

        String expectedPage = "Login Page";
        Log.info("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Book ticket");
        Log.info("Step 2 : Click Book ticket tab ");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), expectedPage, "Page is not displayed as expected ");
        Log.info("Step 3 : Verify that Login page displays ");

    }
    HomePage homePage = new HomePage();
    BookticketPage bookticketPage = new BookticketPage();

}
