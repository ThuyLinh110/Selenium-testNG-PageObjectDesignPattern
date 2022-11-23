package Railway;
import Common.JsonUtils;
import Common.Log;
import Constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest{

    @Test
    public void TC16() {
//      Load data from *.json
        JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
        JSONObject ticket = JsonUtils.getJSONObjectByIndex(ticketList,0);
        int indexDate = Integer.parseInt(ticket.get("Date index").toString());
        String depart = ticket.get("Depart Station").toString();
        String arrive = ticket.get("Arrive Station").toString();
        String seat = ticket.get("Seat").toString();
        String amount = ticket.get("Amount").toString();
        String indexRow = "1";
//      PageObject contructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
//      Excute Testcase
        Log.info("TC16- User can cancel ticket ");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Login");
        loginPage.FillData(validUserName, validPassword);
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
        Log.info(String.format("Step 5 : Click on 'Cancel' button of ticket having No = %s",indexRow));
        myTicketPage.checkCancelTicket(idBtnCancel);
        Log.info("Step 5 : Verify that the canceled ticket is disappeared.");
    }
}
