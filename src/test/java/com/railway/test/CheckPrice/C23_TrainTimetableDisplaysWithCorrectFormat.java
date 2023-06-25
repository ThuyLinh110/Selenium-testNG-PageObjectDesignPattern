package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C23_TrainTimetableDisplaysWithCorrectFormat extends BaseTest {
    @Test(description ="TC 23 - Verify the Train Timetable displays with correct format" )
    public void c23_TrainTimetableDisplaysWithCorrectFormat() {
        headerList.addAll(Arrays.asList("No.", "Depart Station", "Arrive Station", "Depart Time", "Arrive Time", "Check Price", "Book ticket"));

        Allure.step("Step 1: Navigate to Timetable page");
        homePage.clickTab("Timetable");

        Allure.step("Step 2: Verify the Train Timetable page displays");
        Assert.assertEquals(timetablePage.getNameTitlePage(), "Train Timetable");

        Allure.step("Step 3: Verify all headers in the table displays correctly");
        Assert.assertEquals(headerList, timetablePage.getTableHeaderList());

    }


    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    List<String> headerList = new ArrayList<>() ;

}
