package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C27_TicketPricePageDisplaysRespectiveInformationsFromTrainPricingList extends BaseTest {
    @Test(description = "TC 27 - Verify the Ticket Price page displays respective information from Train Pricing List")

    public void C27_TicketPricePageDisplaysRespectiveInformationsFromTrainPricingList() {
        Allure.step("Step 1: Navigate to Train Pricing List");
        homePage.clickTab("Ticket price");

        numberTicketPriceLnk = ticketPricePage.getNumberPriceTicket();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = ticketPricePage.getTitleTicketPriceByIndex(i);

            Allure.step(String.format("Step %s: Click on 'Check Price' button of ticket %s", i*3-1, i));
            ticketPricePage.clickPriceLnkByIndex(i);

            Allure.step(String.format("Step %s: Verify the Ticket Price page displays", i*3));
            Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Ticket Price");

            Allure.step(String.format("Step %s: Verify the Departure/Arrival displays correctly", i*3+1));
            Assert.assertEquals(ticketPricePage.getTicketTitle(),expectedTicketTitle ,"Departure/Arrival displays not correctly");
            ticketPricePage.clickTab("Ticket price");
        }


    }


    HomePage homePage = new HomePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    String expectedTicketTitle;
    int numberTicketPriceLnk ;
}
