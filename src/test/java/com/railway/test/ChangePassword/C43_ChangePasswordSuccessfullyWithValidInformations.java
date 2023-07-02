package com.railway.test.ChangePassword;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.ChangePasswordPage;
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

public class C43_ChangePasswordSuccessfullyWithValidInformations extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test(description = "")
    public void c43_ChangePasswordSuccessfullyWithValidInformations() {

        Allure.step("Step 1: Login with valid account");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 2: Click in Change Password menu tab");
        loginPage.clickTab("Change password");

        Allure.step("Step 3: Generate the random new password");
        newPass = Utilities.getGenerateString(10);

        Allure.step("Step 4: Change password with generated new password");
        changePasswordPage.changePassword(validPassword, newPass, newPass);

        Allure.step("Step 5: Verify the successful message displays");
        Assert.assertEquals(changePasswordPage.getMessageSuccess(), expectedMsg, "Welcome message is not displayed as expected ");

        Allure.step("Step 6: Update new password into data file");
        //      Set data to *.json
        account.put("Password", newPass);
        account.put("User Name", validUserName);
        existedAccountList.set(0,account);
        JsonUtils.setJSONList(Constant.EXISTED_ACC_DATA_PATH, existedAccountList);
    }
    //      Load data from *.json
    JSONArray existedAccountList;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    String newPass ;
    String expectedMsg = "Your password has been updated!";
    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
}
