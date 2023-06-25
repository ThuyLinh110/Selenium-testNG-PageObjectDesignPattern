package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import jdk.jfr.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C41_DeleteTheExpiredTicket extends BaseTest {


    public void C41_DeleteTheExpiredTicket() {
        indexRow = "1";
        homePage.clickTab("Login");
        loginPage.fillData(validUserName, validPassword);
        loginPage.clickBtnLogin();

        homePage.clickTab("Book ticket");


        if (myTicketPage.checkOperationButtonDisplays("Expired")) {
            String idBtnCancel = myTicketPage.getIdOfBtnDelete(indexRow);
            myTicketPage.deleteTicketByValueNo(indexRow);
            myTicketPage.checkCancelTicket(idBtnCancel);
        }
        else {

        }



    }

    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();

    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    List<String> newTicketList = new ArrayList<>();


    JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
    JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
    int indexDate = Integer.parseInt(ticket.get("Date index").toString());
    String depart = ticket.get("Depart Station").toString();
    String arrive = ticket.get("Arrive Station").toString();
    String seat = ticket.get("Seat").toString();
    String amount = ticket.get("Amount").toString();
    String indexRow ;
}
