package com.railway.test.Navigation;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C2_MenuTabsDisplayWithLoggedUser extends BaseTest {
    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for login");
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }

    @Test (description = "TC 2 - Verify the Menu tabs display with logged user", alwaysRun = true)
    public void c2_MenuTabsDisplayWithLoggedUser() {
        Allure.step("Step 1: Login Railway");
        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 2: Verify the Home tab appears");
        homePage.checkTabDisplay("Home");
        Allure.step("Step 3: Verify the FAQ tab appears");
        homePage.checkTabDisplay("FAQ");
        Allure.step("Step 4: Verify the Contact tab appears");
        homePage.checkTabDisplay("Contact");
        Allure.step("Step 5: Verify the Timetable tab appears");
        homePage.checkTabDisplay("Timetable");
        Allure.step("Step 6: Verify the Ticket price tab appears");
        homePage.checkTabDisplay("Ticket price");
        Allure.step("Step 7: Verify the Book ticket tab appears");
        homePage.checkTabDisplay("Book ticket");
        Allure.step("Step 8: Verify the My ticket tab appears");
        homePage.checkTabDisplay("My ticket");
        Allure.step("Step 9: Verify the Change password tab appears");
        homePage.checkTabDisplay("Change password");
        Allure.step("Step 10: Verify the Logout tab appears");
        homePage.checkTabDisplay("Logout");

        Allure.step("Step 11: Verify the Register tab NOT appears");
        homePage.checkTabNotDisplay("Register");
        Allure.step("Step 12: Verify the Login tab NOT appears");
        homePage.checkTabNotDisplay("Login");
    }


    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String validUserName, validPassword;
}
