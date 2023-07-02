package com.railway.test.CheckPrice;

import com.railway.common.Utilities;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C70_TicketPriceTableDisplaysWithCorrectFormat extends BaseTest {

    @Test(description = "TC 70 - Verify the Ticket Price Table displays with correct format")
    public void c70_TicketPriceTableDisplaysWithCorrectFormat() {

    }


    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    String expectedTicketTitle;
    int numberTicketPriceLnk ;
}
