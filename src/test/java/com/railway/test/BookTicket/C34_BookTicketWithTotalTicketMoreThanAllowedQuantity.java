package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
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

public class C34_BookTicketWithTotalTicketMoreThanAllowedQuantity extends BaseTest {
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

////      Excute TestCase
//        homePage.clickTab("Login");
//        loginPage.FillData(validUserName, validPassword);
//        loginPage.clickBtnLogin();
//
//        homePage.clickTab("My ticket");
//        quantity = quantity - myTicketPage.numberTicketAmount();
//        myTicketPage.clickTab("Book ticket");
//        if (quantity < 10) {
//            amount = "" + (quantity +1 );
//        }
//        bookticketPage.FillDataTicket(indexDate, depart, arrive, seat,amount );
//        bookticketPage.clickBookTicketBtn();
//        Assert.assertEquals(bookticketPage.getWelcomeMessage(), expectedErrorMsg, "");

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
    int quantity =10;
    String expectedErrorMsg= "There're errors in the form. Please correct the errors and try again.";

    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
}
