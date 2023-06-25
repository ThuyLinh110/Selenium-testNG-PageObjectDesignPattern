package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
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

import java.util.ArrayList;
import java.util.List;

public class C51_VerifyTheFIlterAppearsWhenTheNumberTicketRecordsMoreThan5 extends BaseTest {
    @Test
    public void c51_VerifyTheFIlterAppearsWhenTheNumberTicketRecordsMoreThan5() {
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);
        homePage.clickTab("My ticket");

        if (myTicketPage.checkManageTableDisplays() ) {
            numberTicketRecord = myTicketPage.numberTicketRecord();
            if (numberTicketRecord > 5) {
                Assert.assertEquals(myTicketPage.checkFilterExist(), true);
            }
            else {
                int indexTicket =0;
                while (numberTicketRecord < 5 ) {
                    homePage.clickTab("Book ticket");

                    JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,indexTicket);
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
                Assert.assertEquals(myTicketPage.checkFilterExist(), false);

                homePage.clickTab("Book ticket");
                bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
                bookticketPage.clickBookTicketBtn();
                bookticketPage.clickTab("My ticket");
                Assert.assertEquals(myTicketPage.checkFilterExist(), true);
            }
        }
        else {
            for (int i=1; i<=5; i++) {
                homePage.clickTab("Book ticket");

                JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,i);
                indexDate = Integer.parseInt(ticket.get("Date index").toString());
                depart = ticket.get("Depart Station").toString();
                arrive = ticket.get("Arrive Station").toString();
                seat = ticket.get("Seat").toString();

                bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
                bookticketPage.clickBookTicketBtn();
            }
            Assert.assertEquals(myTicketPage.checkFilterExist(), false);

            homePage.clickTab("Book ticket");
            bookticketPage.fillDataTicket(indexDate,depart,arrive,seat,"1" );
            bookticketPage.clickBookTicketBtn();
            bookticketPage.clickTab("My ticket");
            Assert.assertEquals(myTicketPage.checkFilterExist(), true);
        }


    }


    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();
    List<String> headerList = new ArrayList<>() ;
    JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,1);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
    int indexDate ;
    String depart, arrive, seat ;
    int numberTicket, numberTicketRecord;

}
