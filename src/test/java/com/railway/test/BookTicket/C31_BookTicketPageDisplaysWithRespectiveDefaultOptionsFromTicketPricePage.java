package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C31_BookTicketPageDisplaysWithRespectiveDefaultOptionsFromTicketPricePage extends BaseTest {
    @Test
    public void c31_BookTicketPageDisplaysWithRespectiveDefaultOptionsFromTicketPricePage() {

//      Excute Testcase
        Log.info("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page ");

        currentDate = Utilities.getCurrentDateByUSFormat();
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        loginPage.clickTab("Ticket price");

        numberTicketPriceLink = ticketPricePage.getNumberPriceTicket();
        for (int i=1; i<= numberTicketPriceLink; i++) {
            expectedDeparture = ticketPricePage.getDepartureByIndex(i);
            expectedArrival = ticketPricePage.getArrivalByIndex(i);
            ticketPricePage.clickPriceLnkByIndex(i);
            numberBookTicketBtn = ticketPricePage.getNumberBookTicketBtn();
            for (int j=1; j<= numberBookTicketBtn; j++) {
                expectedSeatType = ticketPricePage.getSeatType(j);
                ticketPricePage.clickBookTicketBtn(j);
                Assert.assertEquals(bookticketPage.getSelectedDepart(), expectedDeparture);
                Assert.assertEquals(bookticketPage.getSelectedArrive(), expectedArrival);
                Assert.assertEquals(bookticketPage.getSelectedSeatType(), expectedSeatType);

                bookticketPage.gotoPreviousPage();
            }
            bookticketPage.clickTab("Ticket price");
        }


    }
    //      Load data from *.json
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();

    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookticketPage bookticketPage = new BookticketPage();
    int numberBookTicketBtn, numberTicketPriceLink ;
    String expectedDeparture, expectedArrival, selectedDeparture, selectedArrival, expectedSeatType;
    String currentDate;
}
