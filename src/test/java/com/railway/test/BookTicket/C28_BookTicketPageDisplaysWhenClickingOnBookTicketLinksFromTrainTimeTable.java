package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C28_BookTicketPageDisplaysWhenClickingOnBookTicketLinksFromTrainTimeTable extends BaseTest {
    @Test
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
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();

    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    BookticketPage bookticketPage = new BookticketPage();
    int numberBookTicketLink ;
}
