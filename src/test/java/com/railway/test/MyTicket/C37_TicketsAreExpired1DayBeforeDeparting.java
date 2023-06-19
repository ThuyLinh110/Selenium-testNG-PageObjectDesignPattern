package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
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

public class C37_TicketsAreExpired1DayBeforeDeparting extends BaseTest {

    @Test
    public void c37_TicketsAreExpired1DayBeforeDeparting() {
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);
        homePage.clickTab("My ticket");
        if (myTicketPage.checkManageTableDisplays()) {
            departDateList = myTicketPage.getTicketsValueByStatusAndHeader("Expired", "Depart Date");
            expiredDateList = myTicketPage.getTicketsValueByStatusAndHeader("Expired", "Expired Date");

            if (departDateList.size() > 0 && departDateList.size() == expiredDateList.size()) {
                for (int i=1; i<departDateList.size(); i++){
                    Assert.assertTrue(Utilities.compareStringDateByUSFormat(expiredDateList.get(i), departDateList.get(i)));

                }
            }

        }

    }




    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();

    JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    int numberTicket ;
    List<String> departDateList, expiredDateList = new ArrayList<>();
}
