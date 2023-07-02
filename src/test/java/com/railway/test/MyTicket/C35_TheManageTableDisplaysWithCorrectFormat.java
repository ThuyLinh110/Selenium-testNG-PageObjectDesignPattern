package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.*;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C35_TheManageTableDisplaysWithCorrectFormat extends BaseTest {
    @BeforeMethod(description = "Pre-condition", alwaysRun = true)
    public void setUp(){
        Allure.step("Pre-condition 1: Get data from existed account for logging");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();

        Allure.step("Pre-condition 2: Get ticket data for booking ");
        ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
        ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
        indexDate = Integer.parseInt(ticket.get("Date index").toString());
        depart = ticket.get("Depart Station").toString();
        arrive = ticket.get("Arrive Station").toString();
        seat = ticket.get("Seat").toString();
        amount = ticket.get("Amount").toString();
    }

    @Test(description = "TC 35 - Verify the Manage Ticket table displays with correct format")
    @Severity(SeverityLevel.MINOR)
    public void c35_TheManageTableDisplaysWithCorrectFormat() {
        headerList.addAll(Arrays.asList("No.", "Depart Station", "Arrive Station", "Seat Type", "Depart Date", "Book Date", "Expired Date","Status", "Amount", "Total Price", "Operation"));

        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 3: Navigate to My ticket page");
        homePage.clickTab("My ticket");

        int i=3;
        if (!myTicketPage.checkManageTableDisplays()) {
            Allure.step(String.format("Step %d: Book ticket if haven't ticket that already booked", ++i));
            homePage.clickTab("Book ticket");
            bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,amount );
            bookticketPage.clickBookTicketBtn();
            bookticketPage.clickTab("My ticket");
        }

        Allure.step(String.format("Step %d: Verify Manage Tickets page displays", ++i));
        Assert.assertEquals(myTicketPage.getNameTitlePage(), "Manage Tickets");

        Allure.step(String.format("Step %d: Verify the Manage Ticket table displays with correct format", ++i));
        Assert.assertEquals(headerList, myTicketPage.getTableHeaderList());

    }


    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    List<String> headerList = new ArrayList<>() ;
    JSONArray ticketList ;
    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    JSONObject ticket ;
    int indexDate ;
    String depart ;
    String arrive ;
    String seat ;
    String amount ;
}
