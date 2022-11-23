package Railway;
import Common.JsonUtils;
import Common.Log;
import Constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test
    public void TC01() {
//      Load data
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
        String expectedMsg = "Welcome " + validUserName;
//      PageObject
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
//      Excute Testcase
        Log.info("TC01- User can log into Railway with valid username and password ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login(validUserName, validPassword);
        Log.info("Step 3 : Login with valid Email and Password");
        Assert.assertEquals(loginPage.getWelcomeMessage(), expectedMsg, "Welcome message is not displayed as expected ");
        Log.info("Step 4 : Verify that welcome user message is displayed.");

    }

    @Test
    public void TC02() {
//      Load data from *.json
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validPassword = account.get("Password").toString();
        String expectedMsgError = "There was a problem with your login and/or errors exist in your form.";
//      PageObject contructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
//      Excute Testcase
        Log.info("TC02- User can't login with blank 'Username' textbox ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login("", validPassword);
        Log.info("Step 3 : Login with blank userName");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsgError, "Error message is not displayed as expected ");
        Log.info("Step 4 : Verify that User can't login and message 'There was a problem with your login and/or errors exist in your form.' appears. ");

    }

    @Test
    public void TC03() {
//      Load data from *.json
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
        String expectedMsg = "Invalid username or password. Please try again.";
//      PageObject contructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
//      Excute Testcase
        Log.info("TC03- User cannot log into Railway with invalid password ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login(validUserName, validPassword+"123");
        Log.info("Step 3 : Login with valid Email and invalid Password");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg, "Error message is not displayed as expected ");
        Log.info("Step 4 : Verify that error message 'There was a problem with your login and/or errors exist in your form.' is displayed");

    }

    @Test
    public void TC05() {
//      Load data from *.json
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
//      PageObject contructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
//      Excute Testcase
        Log.info("TC05- System shows message when user enters wrong password several times ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click on Login tab ");
        for (int i=1; i<=3; i++){
            loginPage.login(validUserName, validPassword+"123");
            Log.info("Step 3 : Login with valid Email and invalid Password "+i+" time");
        }
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg, "Error message is not displayed as expected ");
        Log.info("Step 4: Verify that User can't login and error message appears.");

    }

    @Test
    public void TC06() {
//      Load data from *.json
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject account = JsonUtils.getJSONObjectByIndex(existedAccountList,0);
        String validUserName = account.get("User Name").toString();
        String validPassword = account.get("Password").toString();
//      PageObject contructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
//      Excute Testcase
        Log.info("TC06- Additional pages display once user logged in ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click on Login tab ");
        loginPage.login(validUserName, validPassword);
        Log.info("Step 3: Login with valid account");
        loginPage.checkTabDisplay("My ticket");
        loginPage.checkTabDisplay("Change password");
        loginPage.checkTabDisplay("Log out");
        Log.info("Step 4: Verify that 'My ticket', 'Change password' and 'Logout' tabs are displayed. ");
        loginPage.clickTab("My ticket");
        Assert.assertEquals(myTicketPage.getNameTitlePage(), "Manage Tickets");
        loginPage.clickTab("Change password");
        Assert.assertEquals(changePasswordPage.getNameTitlePage(), "Change password");
        Log.info("Step 5: Verify that User click 'My ticket', 'Change Password' tab, user will be directed to My ticket, Change Password page ");

    }
    @Test
    public void TC08() {
//      Load data from *.json
        JSONArray newAccountList = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
        JSONObject newAccount = JsonUtils.getJSONObjectByIndex(newAccountList,0);
        String newUserName = newAccount.get("User Name").toString();
        String newPassword = newAccount.get("Password").toString();
        String expectedMsg = "Invalid username or password. Please try again.";
//      PageObject contructor
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
//      Excute Testcase
        Log.info("TC03- User can't login with an account hasn't been registered ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login(newUserName, newPassword);
        Log.info("Step 3 :  Login with username and password of account hasn't been activated.");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg, "Error message is not displayed as expected ");
        Log.info("Step 4 :  Verify that error message appears.");

    }

}
