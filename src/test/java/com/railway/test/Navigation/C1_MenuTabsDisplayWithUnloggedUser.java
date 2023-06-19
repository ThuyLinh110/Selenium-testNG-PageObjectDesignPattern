package com.railway.test.Navigation;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.ChangePasswordPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C1_MenuTabsDisplayWithUnloggedUser extends BaseTest {
    @Test(description = "TC 1 - Verify the Menu tabs display with unlogged user", alwaysRun = true)
    public void c1_MenuTabsDisplayWithUnloggedUser() {

        Allure.step("Step 1: Verify the Home tab appears");
        homePage.checkTabDisplay("Home");
        Allure.step("Step 2: Verify the FAQ tab appears");
        homePage.checkTabDisplay("FAQ");
        Allure.step("Step 3: Verify the Contact tab appears");
        homePage.checkTabDisplay("Contact");
        Allure.step("Step 4: Verify the Timetable tab appears");
        homePage.checkTabDisplay("Timetable");
        Allure.step("Step 5: Verify the Ticket price tab appears");
        homePage.checkTabDisplay("Ticket price");
        Allure.step("Step 6: Verify the Book ticket tab appears");
        homePage.checkTabDisplay("Book ticket");
        Allure.step("Step 7: Verify the Register tab appears");
        homePage.checkTabDisplay("Register");
        Allure.step("Step 8: Verify the Login tab appears");
        homePage.checkTabDisplay("Login");

        Allure.step("Step 9: Verify the My Ticket tab NOT appears");
        homePage.checkTabNotDisplay("My ticket");
        Allure.step("Step 10: Verify the Change password tab NOT appears");
        homePage.checkTabNotDisplay("Change password");
        Allure.step("Step 11: Verify the Log out tab NOT appears");
        homePage.checkTabNotDisplay("Log out");
    }

    HomePage homePage = new HomePage();

}
