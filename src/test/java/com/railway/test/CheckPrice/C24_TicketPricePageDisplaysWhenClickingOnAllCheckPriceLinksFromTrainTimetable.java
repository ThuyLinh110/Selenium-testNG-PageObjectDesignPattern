package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C24_TicketPricePageDisplaysWhenClickingOnAllCheckPriceLinksFromTrainTimetable extends BaseTest {
    @Test(description = "TC 24 - Verify the Ticket Price page displays when clicking on all 'check price' links from Train Timetable ")
    public void C24_TicketPricePageDisplaysWhenClickingOnAllLinksFromTrainTimetable() {
        Allure.step("Step 1: Navigate to Timetable page");
        homePage.clickTab("Timetable");

        numberTicketPriceLnk = timetablePage.getNumberTicketPriceLnk();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = timetablePage.getDynamicTitleTicket(i);

            Allure.step(String.format("Step %s: Click on 'check price' link of ticket %s", i*2, i));
            timetablePage.clickDynamicTicketPriceLink(i);

            Allure.step(String.format("Step %s: Verify the Ticket Price page displays", i*2+1));
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
