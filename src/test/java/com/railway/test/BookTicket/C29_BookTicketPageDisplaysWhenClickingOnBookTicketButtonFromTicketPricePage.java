package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.*;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C29_BookTicketPageDisplaysWhenClickingOnBookTicketButtonFromTicketPricePage extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test(description = "TC 29 - Verify the Book Ticket page displays when clicking on 'Book Ticket' button from Ticket Price page")
    public void c29_BookTicketPageDisplaysWhenClickingOnBookTicketButtonFromTicketPricePage() {

//      Excute Testcase

        currentDate = Utilities.getCurrentDateByUSFormat();
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        loginPage.clickTab("Ticket price");

        numberTicketPriceLink = ticketPricePage.getNumberPriceTicket();
        for (int i=1; i<= numberTicketPriceLink; i++) {
            ticketPricePage.clickPriceLnkByIndex(i);
            numberBookTicketBtn = ticketPricePage.getNumberBookTicketBtn();
            for (int j=1; j<= numberBookTicketBtn; j++) {
                ticketPricePage.clickBookTicketBtn(j);
                Assert.assertEquals(bookticketPage.getNameTitlePage(), "Book ticket");
                bookticketPage.gotoPreviousPage();
            }
            bookticketPage.clickTab("Ticket price");
        }


    }
    //      Load data from *.json
    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;

    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookticketPage bookticketPage = new BookticketPage();
    int numberBookTicketBtn, numberTicketPriceLink ;
    String expectedDeparture, expectedArrival, selectedDeparture, selectedArrival, expectedSeatType;
    String currentDate;

}
