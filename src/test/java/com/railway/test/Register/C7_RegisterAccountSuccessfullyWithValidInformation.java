package com.railway.test.Register;

import com.railway.common.JsonUtils;
import com.railway.common.Log;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C7_RegisterAccountSuccessfullyWithValidInformation extends BaseTest {
/**  Load new data from newAccountList for register account
 *   After register successfully, remove registed data from newAccountList
 *   Insert registed data to existedAccountList
 */
    @Test
    public void c7_RegisterAccountSuccessfullyWithValidInformation() {


//      Excute Testcase
        Log.info("TC07- User can create new account");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register(userName, password, password,PID);
        Log.info("Step 3 : Enter valid information into all fields");
        Log.info("Step 4 : Click on Register button");
        newAccountList.remove(0);
        JsonUtils.setJSONList(Constant.NEW_ACC_DATA_PATH, newAccountList);
        JSONObject account = new JSONObject();
        account.put("User Name", userName);
        account.put("Password", password);
        existedAccountList.add(account);
        JsonUtils.setJSONList(Constant.EXISTED_ACC_DATA_PATH, existedAccountList);
        Assert.assertEquals(registerPage.getMessageSuccess(), expectedMsg, "Message is not displayed as expected");
        Log.info("Step 5 : Verify that success message appears.");

        loginPage.login(userName, password);
        homePage.checkTabNotDisplay("Register");
        homePage.checkTabNotDisplay("Login");

        homePage.checkTabDisplay("My ticket");
        homePage.checkTabDisplay("Change password");
        homePage.checkTabDisplay("Log out");



    }
    //      Load data from *.json
    JSONArray newAccountList = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject newAccount = JsonUtils.getJSONObjectByIndex(newAccountList,0);
    String userName = newAccount.get("User Name").toString();
    String password = newAccount.get("Password").toString();
    String PID = newAccount.get("PID").toString();
    String expectedMsg = "You're here";
    //      PageObject contructor
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
}
