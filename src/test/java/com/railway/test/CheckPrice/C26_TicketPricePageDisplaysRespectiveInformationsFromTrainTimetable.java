package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C26_TicketPricePageDisplaysRespectiveInformationsFromTrainTimetable extends BaseTest {
    @Test
    public void C26_TicketPricePageDisplaysRespectiveInformationsFromTrainTimetable() {
        homePage.clickTab("Timetable");
        numberTicketPriceLnk = timetablePage.getNumberTicketPriceLnk();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = timetablePage.getDynamicTitleTicket(i);
            timetablePage.clickDynamicTicketPriceLink(i);
            Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Ticket Price");
            ticketPricePage.checkTableTicketPriceDisplay();
            Assert.assertEquals(ticketPricePage.getTicketTitle(),expectedTicketTitle ,"Departure/Arrival displays not correctly");
            timetablePage.clickTab("Timetable");
        }


    }


    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    String expectedTicketTitle;
    int numberTicketPriceLnk ;
}
