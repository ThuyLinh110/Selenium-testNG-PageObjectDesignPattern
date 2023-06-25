package com.railway.test.Navigation;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.*;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class C4_RespectivePageDisplaysAfterClickingOnMenuTab extends BaseTest {

    @BeforeMethod(description = "Pre-condition")
    public void setUp() {
        Allure.step("Pre-condition 1: Get account data for  login");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();
    }
    @Test(description = "TC 4 - Verify respective page displays after clicking on menu tabs", alwaysRun = true)
    public void c4_RespectivePageDisplaysAfterClickingOnMenuTab() {
        Allure.step("Step 1: Verify Home page displays after navigate to Railway website");
        Assert.assertEquals(homePage.getNameTitlePage(), "Welcome to Safe Railway");

        Allure.step("Step 2: Click on FAQ menu tab");
        homePage.clickTab("FAQ");
        Allure.step("Step 3: Verify the FAQ page displays");
        Assert.assertEquals(faqPage.getNameTitlePage(), "FAQ");

        Allure.step("Step 4: Click on Contact menu tab");
        homePage.clickTab("Contact");
        Allure.step("Step 5: Verify the Contact page displays");
        Assert.assertEquals(contactPage.getNameTitlePage(), "Contact Information");

        Allure.step("Step 6: Click on Timetable menu tab");
        homePage.clickTab("Timetable");
        Allure.step("Step 7: Verify the Timetable page displays");
        Assert.assertEquals(timetablePage.getNameTitlePage(), "Train Timetable");

        Allure.step("Step 8: Click on Ticket price menu tab");
        homePage.clickTab("Ticket price");
        Allure.step("Step 9: Verify the Ticket price page displays");
        Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Train ticket pricing list");

        Allure.step("Step 10: Click on Book ticket menu tab");
        homePage.clickTab("Book ticket");
        Allure.step("Step 11: Verify the Login page still displays with unlogged user");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Login Page");

        Allure.step("Step 12: Click on Register menu tab");
        homePage.clickTab("Register");
        Allure.step("Step 13: Verify the Register page displays");
        Assert.assertEquals(registerPage.getNameTitlePage(), "Create account");

        Allure.step("Step 14: Click on Login menu tab");
        homePage.clickTab("Login");
        Allure.step("Step 15: Login with valid account");
        loginPage.login(validUserName, validPassword);

        Allure.step("Step 16: Click on My ticket menu tab");
        homePage.clickTab("My ticket");
        Allure.step("Step 17: Verify the My ticket page displays");
        Assert.assertEquals(myTicketPage.getNameTitlePage(), "Manage Tickets");

        Allure.step("Step 18: Click on Change password menu tab");
        homePage.clickTab("Change password");
        Allure.step("Step 19: Verify the Change password page displays");
        Assert.assertEquals(changePasswordPage.getNameTitlePage(), "Change password");

        Allure.step("Step 20: Click on Book ticket menu tab");
        homePage.clickTab("Book ticket");
        Allure.step("Step 21: Verify the Book ticket page displays");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Book ticket");

        Allure.step("Step 22: Click on Log out menu tab");
        homePage.clickTab("Log out");
        Allure.step("Step 23: Verify the Home page displays after user logout");
        Assert.assertEquals(homePage.getNameTitlePage(), "Welcome to Safe Railway");

    }

    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;
    //      PageObject contructor
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    FAQPage faqPage = new FAQPage();
    ContactPage contactPage = new ContactPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookticketPage bookticketPage = new BookticketPage();
    RegisterPage registerPage = new RegisterPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
}
