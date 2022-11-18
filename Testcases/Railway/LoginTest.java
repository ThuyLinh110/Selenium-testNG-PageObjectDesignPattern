package Railway;
import Common.Log;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test
    public void TC01() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Log.info("TC01- User can log into Railway with valid username and password ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Log.info("Step 3 : Enter valid Email and Password");
        Log.info("Step 4 : Click Login button");
        Assert.assertEquals(loginPage.getWelcomeMessage(), expectedMsg, "Welcome message is not displayed as expected ");

    }

    @Test
    public void TC02() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        String expectedMsgError = "There was a problem with your login and/or errors exist in your form.";
        Log.info("TC02- User can't login with blank 'Username' textbox ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login("", Constant.PASSWORD);
        Log.info("Step 3: User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox ");
        Log.info("Step 4 : Click Login button");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsgError, "Error message is not displayed as expected ");

    }

    @Test
    public void TC03() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Log.info("TC03- User cannot log into Railway with invalid password ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
        Log.info("Step 3 : Enter valid Email and invalid Password");
        Log.info("Step 4: Click Login button");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg, "Error message is not displayed as expected ");
    }

    @Test
    public void TC05() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Log.info("TC05- System shows message when user enters wrong password several times ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click on Login tab ");
        for (int i=1; i<=3; i++){
            loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
            Log.info("Step 3 : Enter valid Email and invalid Password ");
            Log.info("Step 4: Click Login button");
        }
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg, "Error message is not displayed as expected ");
    }

    @Test
    public void TC06() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        Log.info("TC06- Additional pages display once user logged in ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click on Login tab ");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Log.info("Step 3: Login with valid account");
        loginPage.checkTabDisplay("My ticket");
        loginPage.checkTabDisplay("Change password");
        loginPage.checkTabDisplay("Log out");
        loginPage.clickTab("My ticket");
        loginPage.clickTab("Change password");
        loginPage.clickTab("Log out");
    }
    @Test
    public void TC08() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Log.info("TC03- User can't login with an account hasn't been activated ");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        Log.info("Step 2 : Click Login tab");
        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
        Log.info("Step 3 :  Enter username and password of account hasn't been activated.");
        Log.info("Step 4: Click Login button");
        Assert.assertEquals(loginPage.getMessageError(), expectedMsg, "Error message is not displayed as expected ");
    }

}
