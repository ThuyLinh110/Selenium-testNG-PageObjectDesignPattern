package com.railway.test.Login;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.ChangePasswordPage;
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

public class C18_LoginSuccessfullyWithValidAccount extends BaseTest {
    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test(description = "TC 18 - Login successfully with valid account")
    @Severity(SeverityLevel.CRITICAL)
    public void c18_LoginSuccessfullyWithValidAccount() {
        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 3: Verify the My ticket menu tab displays");
        homePage.checkTabDisplay("My ticket");

        Allure.step("Step 4: Verify the Change password menu tab displays");
        homePage.checkTabDisplay("Change password");

        Allure.step("Step 5: Verify the Logout menu tab displays");
        homePage.checkTabDisplay("Log out");

        Allure.step("Step 6: Verify the Login menu tab disappears");
        homePage.checkTabNotDisplay("Login");

        Allure.step("Step 7: Verify the Register menu tab disappears");
        homePage.checkTabNotDisplay("Register");


    }
    //      Load data from *.json
    JSONArray existedAccountList;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


}

