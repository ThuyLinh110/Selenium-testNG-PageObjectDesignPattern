package com.railway.test.CheckPrice;

import com.railway.common.Utilities;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C49_TrainTimetableDisplaysWithCorrectInformation extends BaseTest {
    @Test(description = "Verify the Train Timetable displays with correct information")
    public void C49_TrainTimetableDisplaysWithCorrectInformation() {
        Allure.step("Step 1: Navigate to Train Timetable");
        homePage.clickTab("Timetable");

        noList = timetablePage.getAllTicketValueByHeader("No.");
        departStationList = timetablePage.getAllTicketValueByHeader("Depart Station");
        arriveStationList = timetablePage.getAllTicketValueByHeader("Arrive Station");
        departTimeList = timetablePage.getAllTicketValueByHeader("Depart Time");
        arriveTimeList = timetablePage.getAllTicketValueByHeader("Arrive Time");
        checkPriceList = timetablePage.getAllTicketValueByHeader("Check Price");
        bookTicketList = timetablePage.getAllTicketValueByHeader("Book ticket");

        Allure.step("Step 2: Verify the number ticket records by each header are the same");
        Assert.assertEquals(noList.size(), departStationList.size());
        Assert.assertEquals(noList.size(), arriveStationList.size());
        Assert.assertEquals(noList.size(), departTimeList.size());
        Assert.assertEquals(noList.size(), arriveTimeList.size());
        Assert.assertEquals(noList.size(), checkPriceList.size());
        Assert.assertEquals(noList.size(), bookTicketList.size());

        if (departStationList.size() == departTimeList.size()){
            int j=3;
            for (int i=0; i< departStationList.size(); i++) {
                Allure.step(String.format("Step %s: Verify the Depart Station and Arrive Station of ticket %s are different", j, i+1));
                Assert.assertNotEquals(departStationList.get(i), arriveStationList.get(i));

                Allure.step(String.format("Step %s: Verify the Depart Time is sooner than Arrive Time of ticket %s", j++, i+1));
                Assert.assertEquals(Utilities.compareStringByTimeFormat(departTimeList.get(i), arriveTimeList.get(i)), true);
                j+=1;
            }
        }

    }


    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    List<String> departStationList = new ArrayList<>();
    List<String> arriveStationList = new ArrayList<>();
    List<String> departTimeList = new ArrayList<>();
    List<String> arriveTimeList = new ArrayList<>();
    List<String> checkPriceList = new ArrayList<>();
    List<String> bookTicketList = new ArrayList<>();
    List<String> noList = new ArrayList<>();
}
