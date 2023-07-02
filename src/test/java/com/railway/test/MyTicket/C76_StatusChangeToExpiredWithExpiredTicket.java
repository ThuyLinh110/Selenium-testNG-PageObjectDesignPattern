package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C76_StatusChangeToExpiredWithExpiredTicket {
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
    @Test(description = "TC ")
    @Severity(SeverityLevel.CRITICAL)
    public void c76_StatusChangeToExpiredWithExpiredTicket() {
        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 3: Navigate to My ticket page");
        homePage.clickTab("My ticket");

        int i=3;
        if (myTicketPage.checkManageTableDisplays()) {
            departDateList = myTicketPage.getTicketsValueByStatusAndHeader("Expired", "Depart Date");
            expiredDateList = myTicketPage.getTicketsValueByStatusAndHeader("Expired", "Expired Date");

            if (departDateList.size() > 0 && departDateList.size() == expiredDateList.size()) {
                for (int j=1; j<departDateList.size(); j++){
                    Allure.step(String.format("Step %d: Verify the Expired date is sooner 1 day than Depart Date of ticket %d", ++i, j));
                    Assert.assertTrue(Utilities.compareStringDateByUSFormat(expiredDateList.get(j), departDateList.get(j)));
                }
            }
            else {
                Allure.step(String.format("Step %d: Haven't expired tickets for checking ", ++i));
            }
        }
        else {
            Allure.step(String.format("Step %d: Haven't expired tickets for checking ", ++i));
        }
    }




    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
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
    int numberTicket ;
    List<String> departDateList, expiredDateList = new ArrayList<>();
}
