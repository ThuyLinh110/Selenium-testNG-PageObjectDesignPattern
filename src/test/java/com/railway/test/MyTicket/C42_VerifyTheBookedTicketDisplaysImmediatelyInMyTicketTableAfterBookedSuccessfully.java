package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C42_VerifyTheBookedTicketDisplaysImmediatelyInMyTicketTableAfterBookedSuccessfully extends BaseTest {

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

    @Test(description = "TC 42 - Verify the booked ticket displays immediately after booking successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void c42_VerifyTheBookedTicketDisplaysImmediatelyInMyTicketTableAfterBookedSuccessfully() {

        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 3: Navigate to Book ticket page");
        loginPage.clickTab("Book ticket");

        Allure.step("Step 4: Select options and book ticket");
        bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,amount);
        departDate = bookticketPage.getSelectedDate();
        bookticketPage.clickBookTicketBtn();

        Allure.step("Step 5: Navigate to My ticket page");
        bookticketPage.clickTab("My ticket");

        Allure.step("Step 6: Verify the booked ticket displays correct information immediately after booking");
        Assert.assertEquals(myTicketPage.checkTicketExist(depart, arrive, seat,departDate,currentDate,"New", amount), true);


    }
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
    String departDate, currentDate;
    String indexRow = "1";
    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
}
