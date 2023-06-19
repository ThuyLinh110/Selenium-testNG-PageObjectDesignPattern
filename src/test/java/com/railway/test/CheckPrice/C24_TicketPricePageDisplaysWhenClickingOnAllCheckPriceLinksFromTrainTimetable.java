package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C24_TicketPricePageDisplaysWhenClickingOnAllCheckPriceLinksFromTrainTimetable extends BaseTest {
    @Test
    public void C24_TicketPricePageDisplaysWhenClickingOnAllLinksFromTrainTimetable() {
        homePage.clickTab("Timetable");
        numberTicketPriceLnk = timetablePage.getNumberTicketPriceLnk();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = timetablePage.getDynamicTitleTicket(i);
            timetablePage.clickDynamicTicketPriceLink(i);
            Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Ticket Price");
            timetablePage.clickTab("Timetable");
        }


    }


    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    String expectedTicketTitle;
    int numberTicketPriceLnk ;
}
