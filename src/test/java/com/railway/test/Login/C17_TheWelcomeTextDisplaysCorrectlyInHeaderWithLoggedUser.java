package com.railway.test.Login;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C17_TheWelcomeTextDisplaysCorrectlyInHeaderWithLoggedUser extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test (description = "TC 17 - Verify the 'Welcome + username' text displays with logged user", alwaysRun = true)
    public void c17_TheWelcomeTextDisplaysCorrectlyInHeaderWithLoggedUser() {
        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 3: Verify the 'Welcome + username' text displays ");
        expectedMsg = "Welcome " + validUserName ;
        Assert.assertEquals(homePage.getWelcomeMessage(), expectedMsg);

    }


    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg, validPassword, validUserName;
}
