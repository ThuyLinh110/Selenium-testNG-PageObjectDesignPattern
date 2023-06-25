package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C26_TicketPricePageDisplaysRespectiveInformationsFromTrainTimetable extends BaseTest {
    @Test(description = "TC 26 - Verify the Ticket Price page displays respective information from Train Timetable")
    public void C26_TicketPricePageDisplaysRespectiveInformationsFromTrainTimetable() {
        Allure.step("Step 1: Navigate to Train Timetable");
        homePage.clickTab("Timetable");

        numberTicketPriceLnk = timetablePage.getNumberTicketPriceLnk();
        for (int i=1; i<= numberTicketPriceLnk; i++) {
            expectedTicketTitle = timetablePage.getDynamicTitleTicket(i);

            Allure.step(String.format("Step %s: Click on 'check price' link of ticket %s", i*3-1, i));
            timetablePage.clickDynamicTicketPriceLink(i);

            Allure.step(String.format("Step %s: Verify the Ticket Price page displays", i*3));
            Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Ticket Price");

            Allure.step(String.format("Step %s: Verify the Departure/Arrival displays correctly", i*3+1));
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
