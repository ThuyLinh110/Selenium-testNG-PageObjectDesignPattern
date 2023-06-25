package com.railway.test.Register;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C7_RegisterAccountSuccessfullyWithValidInformation extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get data for register");
        newAccountList = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
        newAccount = JsonUtils.getJSONObjectByIndex(newAccountList,0);
        userName = newAccount.get("User Name").toString();
        password = newAccount.get("Password").toString();
        PID = newAccount.get("PID").toString();
    }
    @Test(description = "TC 7 - Verify user can register account with valid information")
    public void c7_RegisterAccountSuccessfullyWithValidInformation() {

        Allure.step("Step 1: Navigate to Register page");
        homePage.clickTab("Register");

        Allure.step("Step 2: Register with valid account");
        registerPage.register(userName, password, password,PID);

        WebElementManager.waitElement(200);

        Allure.step("Step 3: Verify the successful message displays");
        Assert.assertEquals(registerPage.getMessageSuccess(), expectedMsg, "Message is not displayed as expected");

        Allure.step("Step 4: Login with the registered account");
        loginPage.login(userName, password);

        Allure.step("Step 5: Verify the Register tab disappears");
        homePage.checkTabNotDisplay("Register");

        Allure.step("Step 6: Verify the Login tab disappears");
        homePage.checkTabNotDisplay("Login");

        Allure.step("Step 7: Verify the My ticket tab appears");
        homePage.checkTabDisplay("My ticket");

        Allure.step("Step 8: Verify the Change password tab appears");
        homePage.checkTabDisplay("Change password");

        Allure.step("Step 9: Verify the Log out tab appears");
        homePage.checkTabDisplay("Log out");

        Allure.step("Post-condition 1: Remove the registered data from New Account file ");
        newAccountList.remove(0);
        JsonUtils.setJSONList(Constant.NEW_ACC_DATA_PATH, newAccountList);

        Allure.step("Post-condition 2: Insert the registered data into Existed Account file ");
        JSONObject account = new JSONObject();
        account.put("User Name", userName);
        account.put("Password", password);
        existedAccountList.add(account);
        JsonUtils.setJSONList(Constant.EXISTED_ACC_DATA_PATH, existedAccountList);

    }


    //      Load data from *.json
    JSONArray newAccountList ;
    JSONArray existedAccountList;
    JSONObject newAccount;
    String userName ;
    String password ;
    String PID ;
    String expectedMsg = "You're here";
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
}
