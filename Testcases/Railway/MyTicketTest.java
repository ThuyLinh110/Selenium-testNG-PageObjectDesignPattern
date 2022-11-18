package Railway;

import Common.Log;
import Constant.Constant;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest{
    @Test
    public void TC16() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        String depart = "Sài Gòn";
        String arrive = "Huế";
        String seat = "Soft bed with air conditioner";
        String amount = "1";
        int indexDate = 3;
        String indexRow = "1";
        Log.info("TC16- User can cancel ticket ");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Login");
        loginPage.FillData(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account");
        loginPage.clickTab("Book ticket");
        bookticketPage.FillDataTicket(indexDate,depart,arrive,seat,amount);
        bookticketPage.clickBtnBookticket();
        Log.info("Step 3 : Book a ticket");
        bookticketPage.clickTab("My ticket");
        Log.info("Step 4 : Click on My ticket tab");
        String idBtnCancel = myTicketPage.getIdOfBtnCancel(indexRow);
        myTicketPage.cancelTicketByValueNo(indexRow);
        myTicketPage.checkCancelTicket(idBtnCancel);
        Log.info(String.format("Step 5 : Click on 'Cancel' button of ticket having No = %s",indexRow));

    }
}
