package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C28_BookTicketPageDisplaysWhenClickingOnBookTicketLinksFromTrainTimeTable extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test(description = "TC 28 - Verify the Book Ticket page displays when clicking on 'book ticket' links from Train Timetable")
    public void c28_BookTicketPageDisplaysWhenClickingOnBookTicketLinksFromTrainTimeTable() {

//      Excute Testcase

        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        loginPage.clickTab("Timetable");

        numberBookTicketLink = timetablePage.getNumberBookTicketLnk();
        for (int i =1; i<= numberBookTicketLink; i++) {
            timetablePage.clickDynamicBookTicketLink(i);
            Assert.assertEquals(bookticketPage.getNameTitlePage(), "Book ticket");
            bookticketPage.clickTab("Timetable");
        }



    }
    //      Load data from *.json
    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;

    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    BookticketPage bookticketPage = new BookticketPage();
    int numberBookTicketLink ;
}
