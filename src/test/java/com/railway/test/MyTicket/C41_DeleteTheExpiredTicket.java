package com.railway.test.MyTicket;

import com.railway.common.JsonUtils;
import com.railway.constant.Constant;
import com.railway.pageObjects.BookticketPage;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.LoginPage;
import com.railway.pageObjects.MyTicketPage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C41_DeleteTheExpiredTicket extends BaseTest {

    @BeforeMethod(description = "Pre-condition", alwaysRun = true)
    public void setUp(){
        Allure.step("Pre-condition 1: Get data from existed account for logging");
        existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        validUserName = account.get("User Name").toString();
        validPassword = account.get("Password").toString();

    }

    @Test(description = "TC 40 - Verify user can cancel the new ticket successfully")
    @Severity(SeverityLevel.CRITICAL)

    public void c41_DeleteTheExpiredTicket() {
//        indexRow = "1";
//        Allure.step("Step 1: Login Railway");
//        homePage.clickTab("Login");
//        loginPage.login(validUserName, validPassword);
//
//        Allure.step("Step 2: Navigate to My ticket page");
//        loginPage.clickTab("My ticket");
//
//        int i=2;
//        if ( myTicketPage.checkManageTableDisplays() && myTicketPage.checkOperationButtonDisplays("Expired")) {
//            String idBtnCancel = myTicketPage.getIdOfBtnCancel(indexRow);
//
//            Allure.step(String.format("Step %d: Click Cancel button of ticket has No.= %d", ++i, indexRow));
//            myTicketPage.cancelTicketByValueNo(indexRow);
//
//            Allure.step(String.format("Step %d: Verify the deleted ticket disappears", ++i));
//            myTicketPage.checkCancelTicket(idBtnCancel);
//        }



    }

    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    BookticketPage bookticketPage = new BookticketPage();

    JSONArray existedAccountList ;
    JSONObject account ;
    String validUserName ;
    String validPassword ;

    JSONArray ticketList ;
    JSONObject ticket ;
    int indexDate ;
    String depart ;
    String arrive ;
    String seat ;
    String amount ;
    String indexRow ;
}
