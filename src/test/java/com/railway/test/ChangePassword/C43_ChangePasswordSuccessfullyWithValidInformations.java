package com.railway.test.ChangePassword;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import com.railway.pageObjects.ChangePasswordPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C43_ChangePasswordSuccessfullyWithValidInformations extends BaseTest {
    @Test
    public void c43_ChangePasswordSuccessfullyWithValidInformations() {

//      Excute Testcase
        Log.info("TC09- User can change password");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);
        Log.info("Step 2 : Login with valid account");
        loginPage.clickTab("Change password");
        Log.info("Step 3 : Click Change Password tab");
        changePasswordPage.changePassword(validPassword, newPass, newPass);
        Log.info("Step 4 :Fill valid data into all fields");
        Log.info("Step 5 : Click ChangePassword button");
        Assert.assertEquals(changePasswordPage.getMessageSuccess(), expectedMsg, "Welcome message is not displayed as expected ");
        Log.info("Step 6 : Verify that message 'Your password has been updated' appears.");
//      Set data to *.json
        account.put("Password", newPass);
        account.put("User Name", validUserName);
        existedAccountList.set(0,account);
        JsonUtils.setJSONList(Constant.EXISTED_ACC_DATA_PATH, existedAccountList);
    }
    //      Load data from *.json
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
    String newPass = Utilities.getGenerateString(10);
    String expectedMsg = "Your password has been updated!";
    //      Object constructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
}
