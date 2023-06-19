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

public class C17_TheWelcomeTextDisplaysCorrectlyInHeaderWithLoggedUser extends BaseTest {
    @Test
    public void c17_TheWelcomeTextDisplaysCorrectlyInHeaderWithLoggedUser() {
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);
        expectedMsg = "Welcome " + validUserName ;
        Assert.assertEquals(homePage.getWelcomeMessage(), expectedMsg);

    }

    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg;
}
