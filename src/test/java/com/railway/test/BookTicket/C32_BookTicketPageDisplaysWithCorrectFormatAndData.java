package com.railway.test.BookTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.TicketPricePage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C32_BookTicketPageDisplaysWithCorrectFormatAndData extends BaseTest {
    @Test
    public void TC15() {

//      Excute Testcase

        currentDate = Utilities.getCurrentDateByUSFormat();
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        loginPage.clickTab("Book ticket");
        departDateList = bookticketPage.getAllDepartDate();
        for (int i=0; i< departDateList.size(); i++) {
            Assert.assertTrue(Utilities.compareStringDateByUSFormat(currentDate, departDateList.get(i)));

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
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookticketPage bookticketPage = new BookticketPage();
    String currentDate;
    List<String> departDateList = new ArrayList<>();
    List<String> departStationList = new ArrayList<>();
    List<String> arriveStationList = new ArrayList<>();
    List<String> seatTypeList = new ArrayList<>();
    List<String> amountList = new ArrayList<>();


}
