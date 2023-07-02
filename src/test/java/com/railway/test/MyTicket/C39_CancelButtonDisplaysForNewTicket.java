package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
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

public class C39_CancelButtonDisplaysForNewTicket extends BaseTest {

    @BeforeMethod(description = "Pre-condition", alwaysRun = true)
    public void setUp(){
        Allure.step("Pre-condition 1: Get data from existed account for logging");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }

    @Test (description = "TC39 - Verify all Cancel buttons display for all New tickets")
    @Severity(SeverityLevel.NORMAL)
    public void c39_CancelButtonDisplaysForNewTicket() {
        Allure.step("Step 1: Login Railway");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 2: Navigate to My Ticket tab");
        homePage.clickTab("My ticket");

        int i=3;
        if (myTicketPage.checkManageTableDisplays()) {
            newTicketList = myTicketPage.getOperationButtonValueByStatus("New");
            if (newTicketList.size() > 0) {
                for (int j = 0; j< newTicketList.size(); j++) {
                    Allure.step(String.format("Step %d: Verify the Delete button displays for Expired ticket", ++i));
                    Assert.assertEquals(newTicketList.get(j), "Cancel", "");
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

    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    List<String> newTicketList = new ArrayList<>();
}
