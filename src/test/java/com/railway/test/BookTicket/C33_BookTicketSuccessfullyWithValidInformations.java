package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C33_BookTicketSuccessfullyWithValidInformations extends BaseTest {
    @Test
    public void TC15() {

//      Excute TestCase

//        homePage.clickTab("Login");
//        loginPage.FillData(validUserName, validPassword);
//        loginPage.clickBtnLogin();
//        loginPage.clickTab("My ticket");
//        quantity = quantity - myTicketPage.numberTicketAmount()
//        ;
//        if (quantity == 0) {
//            myTicketPage.cancelTicketByValueNo("1");
//        }
//        loginPage.clickTab("Book ticket");
//        bookticketPage.FillDataTicket(indexDate, depart, arrive, seat, amount);
//        String expectedDate = bookticketPage.getSelectedDate();
//        bookticketPage.clickBookTicketBtn();
//        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Ticket Booked Successfully!", "");
//        Log.info("Step 9 : Verify that Message 'Ticket booked successfully!' displays.  ");
//        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Date"), expectedDate, "");
//        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Station"), depart, "");
//        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Arrive Station"), arrive, "");
//        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Seat Type"), seat, "");
//        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Amount"), amount);
//        Log.info("Step 9 : Verify that Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount) ");
//
//


    }
    //      Load data from *.json
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
    JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
    int indexDate = Integer.parseInt(ticket.get("Date index").toString());
    String depart = ticket.get("Depart Station").toString();
    String arrive = ticket.get("Arrive Station").toString();
    String seat = ticket.get("Seat").toString();
    String amount = ticket.get("Amount").toString();
    int quantity = 10;

    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
}
