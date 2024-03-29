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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C44_ChangePasswordWithInvalidCurrentPassword extends BaseTest {
    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test
    public void c44_ChangePasswordWithInvalidCurrentPassword() {

        Allure.step("Step 1: Login with valid account");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 2: Click in Change Password menu tab");
        loginPage.clickTab("Change password");

        Allure.step("Step 3: Generate the random value for current password");
        newPass = Utilities.getGenerateString(10);

        Allure.step("Step 4: Change password with generated new password");
        changePasswordPage.changePassword(newPass, newPass, newPass);

        Allure.step("Step 5: Verify the error message displays");
        Assert.assertEquals(changePasswordPage.getMessageSuccess(), expectedMsg, "Welcome message is not displayed as expected ");

    }
    //      Load data from *.json
    JSONArray existedAccountList;
    JSONObject account ;
    String validUserName ;
    String validPassword ;

    String newPass = Utilities.getGenerateString(10);
    String expectedMsg = "An error occurred when attempting to change the password. Maybe your current password is incorrect.";
    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
}
