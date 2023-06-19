package com.railway.test.Login;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C20_LoginWithInvalidPassword extends BaseTest {
    @Test
    public void LoginWithInvalidPassword() {

//      Login with valid account
//      Verify the Welconme msg , my ticket, change password, logout tabs displays-

        homePage.clickTab("Login");
        loginPage.login(validUserName, password);

        homePage.checkTabNotDisplay("My ticket");
        homePage.checkTabNotDisplay("Change password");
        homePage.checkTabNotDisplay("Log out");

        homePage.checkTabDisplay("Login");
        homePage.checkTabDisplay("Register");

        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);
        Assert.assertEquals(loginPage.getWelcomeMessage(), expectedWelcomeMsg );

    }
    //      Load data from *.json
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String password = "invalidpassword";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg = "Invalid username or password. Please try again.";
    String expectedWelcomeMsg = "Welcome guest";


}
