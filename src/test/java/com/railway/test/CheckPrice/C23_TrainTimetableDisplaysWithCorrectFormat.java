package com.railway.test.CheckPrice;

import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C23_TrainTimetableDisplaysWithCorrectFormat extends BaseTest {
    @Test
    public void TC06() {
        headerList.addAll(Arrays.asList("No.", "Depart Station", "Arrive Station", "Depart Time", "Arrive Time", "Check Price", "Book ticket"));
        homePage.clickTab("Timetable");
        Assert.assertEquals(headerList, timetablePage.getTableHeaderList());
        Assert.assertEquals(timetablePage.getNameTitlePage(), "Train Timetable");
    }


    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    List<String> headerList = new ArrayList<>() ;

}
