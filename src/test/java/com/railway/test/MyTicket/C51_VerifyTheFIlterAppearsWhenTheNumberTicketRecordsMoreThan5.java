package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
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

import java.util.ArrayList;
import java.util.List;

public class C51_VerifyTheFIlterAppearsWhenTheNumberTicketRecordsMoreThan5 extends BaseTest {
    @BeforeMethod(description = "Pre-condition", alwaysRun = true)
    public void setUp(){
        Allure.step("Pre-condition 1: Get data from existed account for logging");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,1);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();

    }
    @Test(description = "")
    @Severity(SeverityLevel.CRITICAL)
    public void c51_VerifyTheFIlterAppearsWhenTheNumberTicketRecordsMoreThan5() {
        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 3: Navigate to My ticket page");
        homePage.clickTab("My ticket");

        int j=3;
        if (myTicketPage.checkManageTableDisplays() ) {
            numberTicketRecord = myTicketPage.numberTicketRecord();
            if (numberTicketRecord > 5) {
                Allure.step(String.format("Step %d: Verify the filter appears when the number of ticket record are more than 6", ++j));
                Assert.assertEquals(myTicketPage.checkFilterExist(), true);
            }
            else {
                int indexTicket =0;
                while (numberTicketRecord < 5 ) {
                    Allure.step(String.format("Step %d: Book more ticket untill the number ticket records = 5 ", ++j));
                    homePage.clickTab("Book ticket");

                    ticket = JsonUtils.getJSONObjectByIndex(ticketList,indexTicket);
                    indexDate = Integer.parseInt(ticket.get("Date index").toString());
                    depart = ticket.get("Depart Station").toString();
                    arrive = ticket.get("Arrive Station").toString();
                    seat = ticket.get("Seat").toString();

                    bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
                    bookticketPage.clickBookTicketBtn();
                    bookticketPage.clickTab("My ticket");
                    numberTicketRecord = myTicketPage.numberTicketRecord();
                    indexTicket +=1;
                }
                Allure.step(String.format("Step %d: Verify the filter not appears when the number ticket records = 5 ", ++j));
                Assert.assertEquals(myTicketPage.checkFilterExist(), false);

                Allure.step(String.format("Step %d: Book more ticket untill the number ticket records > 5 ", ++j));
                homePage.clickTab("Book ticket");
                bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
                bookticketPage.clickBookTicketBtn();

                Allure.step(String.format("Step %d: Go back to My ticket page", ++j));
                bookticketPage.clickTab("My ticket");

                Allure.step(String.format("Step %d: Verify the filter appears when the number ticket records > 5", ++j));
                Assert.assertEquals(myTicketPage.checkFilterExist(), true);
            }
        }
        else {
            for (int i=1; i<=5; i++) {
                Allure.step(String.format("Step %d: Book more ticket untill the number ticket records = 5 ", ++j));
                homePage.clickTab("Book ticket");
                ticket = JsonUtils.getJSONObjectByIndex(ticketList,i);
                indexDate = Integer.parseInt(ticket.get("Date index").toString());
                depart = ticket.get("Depart Station").toString();
                arrive = ticket.get("Arrive Station").toString();
                seat = ticket.get("Seat").toString();

                bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
                bookticketPage.clickBookTicketBtn();
            }
            Allure.step(String.format("Step %d: Verify the filter not appears when the number ticket records = 5 ", ++j));
            Assert.assertEquals(myTicketPage.checkFilterExist(), false);

            Allure.step(String.format("Step %d: Book more ticket untill the number ticket records > 5 ", ++j));
            homePage.clickTab("Book ticket");
            bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
            bookticketPage.clickBookTicketBtn();

            Allure.step(String.format("Step %d: Go back to My ticket page", ++j));
            bookticketPage.clickTab("My ticket");

            Allure.step(String.format("Step %d: Verify the filter appears when the number ticket records > 5", ++j));
            Assert.assertEquals(myTicketPage.checkFilterExist(), true);
        }


    }


    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    List<String> headerList = new ArrayList<>() ;
    JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
    JSONArray existedAccountList ;
    JSONObject account, ticket ;
    String validUserName ;
    String validPassword ;

    int indexDate ;
    String depart, arrive, seat ;
    int numberTicket, numberTicketRecord;

}
