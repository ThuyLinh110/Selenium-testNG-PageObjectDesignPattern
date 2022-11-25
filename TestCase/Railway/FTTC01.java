package Railway;
import Common.Log;
import Constant.Constant;
import Common.JsonUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTTC01 extends BaseTest{

    @Test
    public void FTTC01(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

//      Load data for Register new account
        JSONArray newAccountList1 = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
        JSONArray existedAccountList1 = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject newAccount = JsonUtils.getJSONObjectByIndex(newAccountList1,0);
        String userName = newAccount.get("User Name").toString();
        String password = newAccount.get("Password").toString();
        String PID = newAccount.get("PID").toString();
//      Register account
        homePage.clickTab("Register");
        registerPage.register(userName, password, password,PID);
//      Save registed account
        newAccountList1.remove(0);
        JsonUtils.setJSONList(Constant.NEW_ACC_DATA_PATH, newAccountList1);
        JSONObject account1 = new JSONObject();
        account1.put("User Name", userName);
        account1.put("Password", password);
        existedAccountList1.add(account1);
        JsonUtils.setJSONList(Constant.EXISTED_ACC_DATA_PATH, existedAccountList1);

//      Load data for login
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
//      Load data for book ticket
        JSONArray ticketList = JsonUtils.getJSONList(Constant.BOOKTICKET_DATA_PATH);
        int numberTicket = 6;
        int numberRemainTicket = 10 - numberTicket;
        String expectedNote = "You currently book "+ numberTicket+" tickets, you can book "+numberRemainTicket+" more.";
        JSONObject ticket = new JSONObject();
//      Excute TestCase
        Log.info("TestCase FTTC01 : 'Manage ticket' displays remaining available number of booking");
        Log.info("Step 1 : Navigate to Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Login with valid account");
        loginPage.login(validUserName, validPassword);
        loginPage.clickTab("Book ticket");
        for (int i=0; i<numberTicket; i++){
            ticket = JsonUtils.getJSONObjectByIndex(ticketList,i);
            int indexDate = Integer.parseInt(ticket.get("Date index").toString());
            String depart = ticket.get("Depart Station").toString();
            String arrive = ticket.get("Arrive Station").toString();
            String seat = ticket.get("Seat").toString();
            String amount = ticket.get("Amount").toString();
            bookticketPage.bookTicket(indexDate, depart, arrive, seat, amount);
            bookticketPage.clickTab("Book ticket");
        }
        Log.info(String.format("Step 3 : Book %s tickets with different Depart Dates ", numberTicket));
        bookticketPage.clickTab("My ticket");
        Log.info("Step 4 : Verify that note message is displayed as expected");
        Assert.assertEquals(myTicketPage.getLblNote(), expectedNote, "Note message is not displayed as expected");

    }
}
