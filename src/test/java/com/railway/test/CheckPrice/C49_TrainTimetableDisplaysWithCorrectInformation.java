package com.railway.test.CheckPrice;

import com.railway.common.Utilities;
import com.railway.pageObjects.HomePage;
import com.railway.pageObjects.TimetablePage;
import com.railway.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C49_TrainTimetableDisplaysWithCorrectInformation extends BaseTest {
    @Test
    public void C49_TrainTimetableDisplaysWithCorrectInformation() {
        homePage.clickTab("Timetable");

        noList = timetablePage.getAllTicketValueByHeader("No.");
        departStationList = timetablePage.getAllTicketValueByHeader("Depart Station");
        arriveStationList = timetablePage.getAllTicketValueByHeader("Arrive Station");
        departTimeList = timetablePage.getAllTicketValueByHeader("Depart Time");
        arriveTimeList = timetablePage.getAllTicketValueByHeader("Arrive Time");
        checkPriceList = timetablePage.getAllTicketValueByHeader("Check Price");
        bookTicketList = timetablePage.getAllTicketValueByHeader("Book ticket");
        Assert.assertEquals(noList.size(), departStationList.size());
        Assert.assertEquals(noList.size(), arriveStationList.size());
        Assert.assertEquals(noList.size(), departTimeList.size());
        Assert.assertEquals(noList.size(), arriveTimeList.size());
        Assert.assertEquals(noList.size(), checkPriceList.size());
        Assert.assertEquals(noList.size(), bookTicketList.size());


        if (departStationList.size() == departTimeList.size()){
            for (int i=0; i< departStationList.size(); i++) {
                Assert.assertNotEquals(departStationList.get(i), arriveStationList.get(i));
            }
        }
        if (departTimeList.size() == arriveTimeList.size()){
            for (int i=0; i< departTimeList.size(); i++) {
                Assert.assertEquals(Utilities.compareStringByTimeFormat(departTimeList.get(i), arriveTimeList.get(i)), true);
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
