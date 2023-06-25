package com.railway.test.Register;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C12_RegisterAccountFailedWithEmailAlreadyExisted extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get the registered email data for register account ");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        existedAccount = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        existedUserName = existedAccount.get("User Name").toString();
        password = "123456789";
        PID = "123456789";
    }
    @Test(description = "TC 12 - Verify user cannot register account with email that already existed")
    public void c12_RegisterAccountFailedWithEmailAlreadyExisted() {
        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with the email that already existed");
        registerPage.register(existedUserName, password, password,PID);

        Allure.step("Step 3: Verify the error message displays");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

    }
    //      Load data from *.json
    JSONArray existedAccountList ;
    JSONObject existedAccount ;
    String existedUserName ;
    String password ;
    String PID ;
    String expectedMsg = "This email address is already in use.";
    //      PageObject contructor
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
