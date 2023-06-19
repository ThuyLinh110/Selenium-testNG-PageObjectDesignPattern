package com.railway.test.Register;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.RegisterPage;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C12_RegisterAccountWithEmailAlreadyExisted extends BaseTest {
    @Test
    public void c12_RegisterAccountWithEmailAlreadyExisted() {



        homePage.clickTab("Register");
        registerPage.register(existedUserName, password, password,PID);
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Message is not displayed as expected");

    }
    //      Load data from *.json
    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject existedAccount = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String existedUserName = existedAccount.get("User Name").toString();
    String password = "123456789";
    String PID = "123456789";
    String expectedMsg = "This email address is already in use.";
    //      PageObject contructor
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
}
