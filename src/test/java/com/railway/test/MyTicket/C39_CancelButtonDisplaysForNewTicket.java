package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import jdk.jfr.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C39_CancelButtonDisplaysForNewTicket extends BaseTest {

    @Test(priority = 0, description="Testcase39..............")
    @Description("Testcase39..............")

    public void C38_DeleteButtonDisplaysForExpiredTicket() {
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);
        homePage.clickTab("My ticket");
        if (myTicketPage.checkManageTableDisplays()) {
            expiredTicketList = myTicketPage.getOperationButtonValueByStatus("New");
            if (expiredTicketList.size() > 0) {
                for (int i=0; i<expiredTicketList.size(); i++) {
                    Assert.assertEquals(expiredTicketList.get(i), "Cancel");
                }
            }

        }

    }

    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();

    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    List<String> expiredTicketList = new ArrayList<>();
}
