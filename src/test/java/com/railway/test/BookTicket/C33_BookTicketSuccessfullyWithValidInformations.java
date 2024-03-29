package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C33_BookTicketSuccessfullyWithValidInformations extends BaseTest {
    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }

    @Test
    public void TC15() {

//      Excute TestCase

        homePage.clickTab("Login");
        loginPage.fillData(validUserName, validPassword);
        loginPage.clickBtnLogin();
        loginPage.clickTab("My ticket");
        quantity = quantity - myTicketPage.getNumberTicketByStatus("New")
        ;
        if (quantity == 0) {
            myTicketPage.cancelTicketByValueNo("1");
        }
        loginPage.clickTab("Book ticket");
        bookticketPage.fillDataTicket(indexDate, depart, arrive, seat, amount);
        String expectedDate = bookticketPage.getSelectedDate();
        bookticketPage.clickBookTicketBtn();
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Ticket Booked Successfully!", "");
        Log.info("Step 9 : Verify that Message 'Ticket booked successfully!' displays.  ");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Date"), expectedDate, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Station"), depart, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Arrive Station"), arrive, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Seat Type"), seat, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Amount"), amount);
        Log.info("Step 9 : Verify that Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount) ");




    }
    //      Load data from *.json
    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
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
