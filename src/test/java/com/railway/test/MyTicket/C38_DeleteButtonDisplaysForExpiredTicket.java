package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;

public class C38_DeleteButtonDisplaysForExpiredTicket extends BaseTest {

    @BeforeMethod(description = "Pre-condition", alwaysRun = true)
    public void setUp(){
        Allure.step("Pre-condition 1: Get data from existed account for logging");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }

    @Test (description = "TC38 - Verify all Delete buttons display for all expired tickets")
    public void C38_DeleteButtonDisplaysForExpiredTicket() {
        Allure.step("Step 1: Login Railway");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 2: Navigate to My Ticket tab");
        homePage.clickTab("My ticket");

        Allure.step("Step 4: Verify all Delete buttons display for all Expired tickets");
        if (myTicketPage.checkManageTableDisplays()) {
            expiredTicketList = myTicketPage.getOperationButtonValueByStatus("Expired");
            if (expiredTicketList.size() > 0) {
                for (int i=0; i<expiredTicketList.size(); i++) {
                    Assert.assertEquals(expiredTicketList.get(i), "Delete", "Verify the Delete button displays for Expired ticket");
                }
            }
        }
    }

    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();

    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    List<String> expiredTicketList = new ArrayList<>();
}
