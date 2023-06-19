package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C25_TicketPricePageDisplaysWhenClickingOnAllCheckPriceButtonsFromTrainPricingList extends BaseTest {
    @Test
    public void C25_TicketPricePageDisplaysWhenClickingOnAllCheckPriceButtonsFromTrainPricingList() {
        homePage.clickTab("Ticket price");
        numberTicketPriceLnk = ticketPricePage.getNumberPriceTicket();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = ticketPricePage.getTitleTicketPriceByIndex(i);
            ticketPricePage.clickPriceLnkByIndex(i);
            Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Ticket Price");
            ticketPricePage.clickTab("Ticket price");
        }


    }


    HomePage homePage = new HomePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    String expectedTicketTitle;
    int numberTicketPriceLnk ;
}
