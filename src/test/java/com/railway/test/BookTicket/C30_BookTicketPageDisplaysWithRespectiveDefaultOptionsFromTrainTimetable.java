package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
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

import java.util.Base64;

public class C30_BookTicketPageDisplaysWithRespectiveDefaultOptionsFromTrainTimetable extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }

    @Test
    public void c30_BookTicketPageDisplaysWithRespectiveDefaultOptionsFromTrainTimetable() {

//      Excute Testcase

        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        loginPage.clickTab("Timetable");

        numberBookTicketLink = timetablePage.getNumberBookTicketLnk();
        for (int i =1; i<= numberBookTicketLink; i++) {
            expectedDeparture = timetablePage.getDynamicDepart(i);
            expectedArrival = timetablePage.getDynamicArrive(i);
            timetablePage.clickDynamicBookTicketLink(i);
            selectedDeparture = bookticketPage.getSelectedDepart();
            selectedArrival = bookticketPage.getSelectedArrive();
            Assert.assertEquals(bookticketPage.getNameTitlePage(), "Book ticket");
            Assert.assertEquals(bookticketPage.getSelectedDepart(), expectedDeparture);
            Assert.assertEquals(bookticketPage.getSelectedArrive(), expectedArrival);
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
    String expectedDeparture, expectedArrival, selectedDeparture, selectedArrival;
}
