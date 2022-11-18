package Railway;

import Common.Log;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookticketTest extends BaseTest {
    @Test
    public void TC04() {
        HomePage homePage = new HomePage();
        BookticketPage bookticketPage = new BookticketPage();
        String expectedPage = "Login Page";
        Log.info("TC04- Login page displays when un-logged User clicks on 'Book ticket' tab");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Book ticket");
        Log.info("Step 2 : Click Book ticket tab ");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), expectedPage, "Page is not displayed as expected ");

    }

    @Test
    public void TC14() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        String depart = "Sài Gòn";
        String arrive = "Nha Trang";
        String seat = "Soft bed with air conditioner";
        String amount = "1";
        Log.info("TC14- User can book 1 ticket at a time ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        loginPage.FillData(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account ");
        loginPage.clickTab("Book ticket");
        Log.info("Step 3 : Click on Book ticket tab ");
        bookticketPage.FillDataTicket(3, depart, arrive, seat, amount);
        Log.info("Step 4 : Select a 'Depart date' from the list");
        Log.info(String.format("Step 5 : Select '%s' for 'Depart from' and '%s' for 'Arrive at' ",depart,arrive));
        Log.info(String.format("Step 6 : Select '%s' for 'Seat type' ", seat));
        Log.info(String.format("Step 7 : Select '%s' for 'Ticket amount' ", amount));
        String expectedDate = bookticketPage.getSelectedDate();
        bookticketPage.clickBtnBookticket();
        Log.info("Step 8 : Click Bookticket ");
        Assert.assertEquals(bookticketPage.getNameTitlePage(), "Ticket Booked Successfully!", "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Date"), expectedDate, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Depart Station"), depart, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Arrive Station"), arrive, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Seat Type"), seat, "");
        Assert.assertEquals(bookticketPage.getValueOfTicketByHeader("Amount"), amount);
    }

    @Test
    public void TC15() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimetablePage timetablePage = new TimetablePage();
        BookticketPage bookticketPage = new BookticketPage();
        String expectedDepart = "Huế";
        String expectedArrive = "Sài Gòn";
        String expectedTitle = "Book ticket";
        Log.info("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        loginPage.FillData(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account ");
        loginPage.clickTab("Timetable");
        Log.info("Step 3 : Click on Timetable tab ");
        timetablePage.clickBookTicketLink(expectedDepart, expectedArrive);
        Log.info(String.format("Step 4 : Click on 'book ticket' link of the route from '%s' to '%s' ",expectedDepart, expectedArrive));
        Assert.assertEquals(bookticketPage.getNameTitlePage(), expectedTitle);
        Assert.assertEquals(bookticketPage.getSelectedDepart(), expectedDepart);
        Assert.assertEquals(bookticketPage.getSelectedArrive(), expectedArrive);

    }
}
