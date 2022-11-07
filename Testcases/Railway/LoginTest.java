package Railway;
import Common.Utilities;
import Constant.Constant;
import Railway.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void beforeMethod()
    {

        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver",Utilities.getPathProject()+"\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01()
    {
        System.out.println("TC01- User can login with valid account ");
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String expectedMsg = "Welcome "+Constant.USERNAME;
        String actualMsg = loginPage.getWelcomeMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected ");


    }

}
