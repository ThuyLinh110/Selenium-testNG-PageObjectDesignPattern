package com.railway.test.ChangePassword;

import com.railway.common.JsonUtils;
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

public class C46_ChangePasswordFailedWithNewPasswordLengthShorterThanAllowed extends BaseTest {
    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test
    public void c46_ChangePasswordFailedWithNewPasswordLengthShorterThanAllowed() {

        Allure.step("Step 1: Login with valid account");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 2: Click in Change Password menu tab");
        loginPage.clickTab("Change password");

        Allure.step("Step 3: Generate the random value for new password");
        newPass = Utilities.getGenerateString(7);

        Allure.step("Step 4: Change password with new password and confirm password not matched");
        changePasswordPage.changePassword(validPassword, newPass, newPass+"123");

        Allure.step("Step 5: Verify the error message displays");
        Assert.assertEquals(changePasswordPage.getMessageSuccess(), expectedMsg, "Welcome message is not displayed as expected ");

    }
    //      Load data from *.json
    JSONArray existedAccountList;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    String newPass = Utilities.getGenerateString(10);
    String expectedMsg = "Password change failed. Please correct the errors and try again.";
    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
}
