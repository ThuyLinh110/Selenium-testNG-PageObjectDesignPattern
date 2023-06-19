package com.railway.test.Login;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.ChangePasswordPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C18_LoginSuccessfullyWithValidAccount extends BaseTest {
    @Test
    public void c18_LoginSuccessfullyWithValidAccount() {

        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        homePage.checkTabDisplay("My ticket");
        homePage.checkTabDisplay("Change password");
        homePage.checkTabDisplay("Log out");

        homePage.checkTabNotDisplay("Login");
        homePage.checkTabNotDisplay("Register");

        homePage.clickTab("My ticket");
        Assert.assertEquals(myTicketPage.getNameTitlePage(), "Manage Tickets");
        homePage.clickTab("Change password");
        Assert.assertEquals(changePasswordPage.getNameTitlePage(), "Change password");
        homePage.clickTab("Log out");
        Assert.assertEquals(changePasswordPage.getNameTitlePage(), "Welcome to Safe Railway");

    }
    //      Load data from *.json
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

}

