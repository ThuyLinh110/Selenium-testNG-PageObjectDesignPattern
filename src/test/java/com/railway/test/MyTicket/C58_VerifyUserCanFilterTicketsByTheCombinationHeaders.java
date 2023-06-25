package com.railway.test.MyTicket;

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

public class C58_VerifyUserCanFilterTicketsByTheCombinationHeaders extends BaseTest {
    @BeforeMethod(description = "Pre-condition", alwaysRun = true)
    public void setUp() {
        Allure.step("Pre-condition 1: Get account and ticket data");
        ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,1);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();

        Allure.step("Pre-condition 2: Verify the filter appears when the number booked tickets are more than 5 ");
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

                ticket = JsonUtils.getJSONObjectByIndex(ticketList,i);
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


    @Test
    public void c58_VerifyUserCanFilterTicketsByTheCombinationHeaders() {

        firstDepart = myTicketPage.getFirstTicketValueByHeader("Depart Station");
        firstArrive = myTicketPage.getFirstTicketValueByHeader("Arrive Station");
        numberTicketByDepartValue = myTicketPage.getTicketsByFilter(firstDepart, firstArrive,"","");
        myTicketPage.fillDataFilter(firstDepart,firstArrive, null, null);
        myTicketPage.clickApplyFilterButton();
        numberTicketByFilter = myTicketPage.numberTicketRecord();
        Assert.assertEquals(numberTicketByFilter, numberTicketByDepartValue);


        myTicketPage.clickTab("My ticket");
        firstDepart = myTicketPage.getFirstTicketValueByHeader("Depart Station");
        firstDate = myTicketPage.getFirstTicketValueByHeader("Depart Date");
        numberTicketByDepartValue = myTicketPage.getTicketsByFilter(firstDepart, "",firstDate,"");
        myTicketPage.fillDataFilter(firstDepart,null, firstDate, null);
        myTicketPage.clickApplyFilterButton();
        numberTicketByFilter = myTicketPage.numberTicketRecord();
        Assert.assertEquals(numberTicketByFilter, numberTicketByDepartValue);

        myTicketPage.clickTab("My ticket");
        firstDepart = myTicketPage.getFirstTicketValueByHeader("Depart Station");
        firstStatus = myTicketPage.getFirstTicketValueByHeader("Status");
        numberTicketByDepartValue = myTicketPage.getTicketsByFilter(firstDepart, "","",firstStatus);
        myTicketPage.fillDataFilter(firstDepart,null, null, firstStatus);
        myTicketPage.clickApplyFilterButton();
        numberTicketByFilter = myTicketPage.numberTicketRecord();
        Assert.assertEquals(numberTicketByFilter, numberTicketByDepartValue);

        myTicketPage.clickTab("My ticket");
        firstDepart = myTicketPage.getFirstTicketValueByHeader("Depart Station");
        firstArrive = myTicketPage.getFirstTicketValueByHeader("Arrive Station");
        firstStatus = myTicketPage.getFirstTicketValueByHeader("Status");
        numberTicketByDepartValue = myTicketPage.getTicketsByFilter(firstDepart, firstArrive,"",firstStatus);
        myTicketPage.fillDataFilter(firstDepart,firstArrive, null, firstStatus);
        myTicketPage.clickApplyFilterButton();
        numberTicketByFilter = myTicketPage.numberTicketRecord();
        Assert.assertEquals(numberTicketByFilter, numberTicketByDepartValue);

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
    String depart, arrive, seat ;
    int numberTicket, numberTicketRecord;
    String firstDepart, firstArrive, firstDate, firstStatus;
    int numberTicketByFilter, numberTicketByDepartValue;
}
