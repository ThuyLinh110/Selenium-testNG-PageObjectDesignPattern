package com.railway.test.MyTicket;

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
import org.testng.annotations.Test;

public class TheBookedTicketDisplaysInMyTicketTable extends BaseTest {
    @Test
    public void TC16() {

//      Excute Testcase
        Log.info("TC16- User can cancel ticket ");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Login");
        loginPage.fillData(validUserName, validPassword);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account");
        loginPage.clickTab("Book ticket");
        bookticketPage.FillDataTicket(indexDate,depart,arrive,seat,amount);
        bookticketPage.clickBookTicketBtn();
        Log.info("Step 3 : Book a ticket");
        bookticketPage.clickTab("My ticket");
        Log.info("Step 4 : Click on My ticket tab");

    }
    //      Load data from *.json
    JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
    int indexDate = Integer.parseInt(ticket.get("Date index").toString());
    String depart = ticket.get("Depart Station").toString();
    String arrive = ticket.get("Arrive Station").toString();
    String seat = ticket.get("Seat").toString();
    String amount = ticket.get("Amount").toString();
    String indexRow = "1";
    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
}
