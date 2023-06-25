package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.*;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C35_TheManageTableDisplaysWithCorrectFormat extends BaseTest {
    @Test
    public void c35_TheManageTableDisplaysWithCorrectFormat() {
        headerList.addAll(Arrays.asList("No.", "Depart Station", "Arrive Station", "Seat Type", "Depart Date", "Book Date", "Expired Date","Status", "Amount", "Total Price", "Operation"));
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);
        homePage.clickTab("My ticket");
        if (!myTicketPage.checkManageTableDisplays()) {
            homePage.clickTab("Book ticket");
            bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,amount );
            bookticketPage.clickBookTicketBtn();
            bookticketPage.clickTab("My ticket");
        }
            Assert.assertEquals(headerList, myTicketPage.getTableHeaderList());
            Assert.assertEquals(myTicketPage.getNameTitlePage(), "Manage Tickets");

    }


    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    List<String> headerList = new ArrayList<>() ;
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
}
