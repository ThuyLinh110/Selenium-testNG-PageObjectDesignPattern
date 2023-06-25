package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C25_TicketPricePageDisplaysWhenClickingOnAllCheckPriceButtonsFromTrainPricingList extends BaseTest {
    @Test(description = "TC 25 - Verify the Ticket Price page displays when clicking on all 'Check Price' button from Train Pricing List ")
    public void C25_TicketPricePageDisplaysWhenClickingOnAllCheckPriceButtonsFromTrainPricingList() {
        Allure.step("Step 1: Navigate to Train Ticket Pricing List");
        homePage.clickTab("Ticket price");

        numberTicketPriceLnk = ticketPricePage.getNumberPriceTicket();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = ticketPricePage.getTitleTicketPriceByIndex(i);

            Allure.step(String.format("Step %s: Click on 'Check Price' button of ticket %s", i*2, i));
            ticketPricePage.clickPriceLnkByIndex(i);

            Allure.step(String.format("Step %s: Verify the Ticket Price page displays", i*2+1));
            Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Ticket Price");
            ticketPricePage.clickTab("Ticket price");
        }

    }


    HomePage homePage = new HomePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    String expectedTicketTitle;
    int numberTicketPriceLnk ;
}
