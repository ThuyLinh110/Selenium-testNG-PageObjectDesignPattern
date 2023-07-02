package com.railway.test.Login;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C20_LoginFailedWithInvalidPassword extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        password = "invalidpassword";
    }

    @Test(description = "TC 20 - Login failed with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    public void c20_LoginWithInvalidPassword() {

        Allure.step("Step 1: Navigate to Login page");
        homePage.clickTab("Login");

        Allure.step("Step 2: Login with the random password");
        loginPage.login(validUserName, password);

        Allure.step("Step 3: Verify error message displays");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg);

        Allure.step("Step 4: Verify My ticket menu tab not displays");
        homePage.checkTabNotDisplay("My ticket");

        Allure.step("Step 5: Verify Change password menu tab not displays");
        homePage.checkTabNotDisplay("Change password");

        Allure.step("Step 6: Verify Log out menu tab not displays");
        homePage.checkTabNotDisplay("Log out");

        Allure.step("Step 7: Verify Login menu tab still displays");
        homePage.checkTabDisplay("Login");

        Allure.step("Step 8: Verify Register menu tab still displays");
        homePage.checkTabDisplay("Register");

    }
    JSONArray existedAccountList;
    JSONObject account;
    String validUserName ;
    String password ;
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String expectedMsg = "Invalid username or password. Please try again.";
    String expectedWelcomeMsg = "Welcome guest";


}
