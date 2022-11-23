package Railway;
import Common.JsonUtils;
import Common.Log;
import Constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookticketTest extends BaseTest {

    @Test
    public void TC04() {
        HomePage homePage = new HomePage();
        BookticketPage bookticketPage = new BookticketPage();
        String expectedPage = "Login Page";
        Log.info("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Book ticket");
        Log.info("Step 2 : Click Book ticket tab ");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), expectedPage, "Page is not displayed as expected ");
        Log.info("Step 3 : Verify that Login page displays ");

    }

    @Test
    public void TC14() {
//      Load data from *.json
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
        JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
        JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
        int indexDate = Integer.parseInt(ticket.get("Date index").toString());
        String depart = ticket.get("Depart Station").toString();
        String arrive = ticket.get("Arrive Station").toString();
        String seat = ticket.get("Seat").toString();
        String amount = ticket.get("Amount").toString();
//      Object constructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
//      Excute TestCase
        Log.info("TC14- User can book 1 ticket at a time ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        loginPage.FillData(validUserName, validPassword);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account ");
        loginPage.clickTab("Book ticket");
        Log.info("Step 3 : Click on Book ticket tab ");
        bookticketPage.FillDataTicket(indexDate, depart, arrive, seat, amount);
        Log.info("Step 4 : Select 'Depart date' from the list");
        Log.info(String.format("Step 5 : Select '%s' for 'Depart from' and '%s' for 'Arrive at' ",depart,arrive));
        Log.info(String.format("Step 6 : Select '%s' for 'Seat type' ", seat));
        Log.info(String.format("Step 7 : Select '%s' for 'Ticket amount' ", amount));
        String expectedDate = bookticketPage.getSelectedDate();
        bookticketPage.clickBtnBookticket();
        Log.info("Step 8 : Click Bookticket ");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Ticket Booked Successfully!", "");
        Log.info("Step 9 : Verify that Message 'Ticket booked successfully!' displays.  ");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Date"), expectedDate, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Station"), depart, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Arrive Station"), arrive, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Seat Type"), seat, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Amount"), amount);
        Log.info("Step 9 : Verify that Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount) ");

    }

    @Test
    public void TC15() {
//      Load data from *.json
        JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
        JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,1);
        String expectedDepart = ticket.get("Depart Station").toString();
        String expectedArrive = ticket.get("Arrive Station").toString();
//      Object constructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimetablePage timetablePage = new TimetablePage();
        BookticketPage bookticketPage = new BookticketPage();
//      Excute Testcase
        Log.info("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        loginPage.FillData(validUserName, validPassword);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account ");
        loginPage.clickTab("Timetable");
        Log.info("Step 3 : Click on Timetable tab ");
        timetablePage.clickBookTicketLink(expectedDepart, expectedArrive);
        Log.info(String.format("Step 4 : Click on 'book ticket' link of the route from '%s' to '%s' ",expectedDepart, expectedArrive));
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Book ticket");
        Assert.assertEquals(bookticketPage.getSelectedDepart(), expectedDepart);
        Assert.assertEquals(bookticketPage.getSelectedArrive(), expectedArrive);
        Log.info("Step 4 : Verify that 'Book ticket' page is loaded with correct 'Depart from' and 'Arrive at' values. ");


    }
}
