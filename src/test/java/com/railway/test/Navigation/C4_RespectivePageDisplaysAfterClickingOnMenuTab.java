package com.railway.test.Navigation;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.*;
import com.railway.test.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class C4_RespectivePageDisplaysAfterClickingOnMenuTab extends BaseTest {
    @Test
    public void c2_MenuTabsDisplayWithLoggedUser() {
        Assert.assertEquals(homePage.getNameTitlePage(), "Welcome to Safe Railway");


        homePage.clickTab("FAQ");
        Assert.assertEquals(faqPage.getNameTitlePage(), "FAQ");

        homePage.clickTab("Contact");
        Assert.assertEquals(contactPage.getNameTitlePage(), "Contact Information");

        homePage.clickTab("Timetable");
        Assert.assertEquals(timetablePage.getNameTitlePage(), "Train Timetable");

        homePage.clickTab("Ticket price");
        Assert.assertEquals(ticketPricePage.getNameTitlePage(), "Train ticket pricing list");

        homePage.clickTab("Book ticket");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Login Page");

        homePage.clickTab("Register");
        Assert.assertEquals(registerPage.getNameTitlePage(), "Create account");

        homePage.clickTab("Login");
        loginPage.login(validUserName, validPassword);

        homePage.clickTab("My ticket");
        Assert.assertEquals(myTicketPage.getNameTitlePage(), "Manage Tickets");

        homePage.clickTab("Change password");
        Assert.assertEquals(changePasswordPage.getNameTitlePage(), "Change password");

        homePage.clickTab("Book ticket");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Book ticket");

        homePage.clickTab("Log out");
        Assert.assertEquals(homePage.getNameTitlePage(), "Welcome to Safe Railway");


    }

    JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
    JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
    String validUserName = account.get("User Name").toString();
    String validPassword = account.get("Password").toString();
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
