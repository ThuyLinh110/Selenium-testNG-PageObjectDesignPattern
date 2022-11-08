package Railway;

import Common.Utilities;
import Common.ExcelUtils;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getPathProject() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01- User can login with valid account ");
        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String expectedMsg = "Welcome " + Constant.USERNAME;
        String actualMsg = loginPage.getWelcomeMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected ");
    }

    @Test
    public void TC02() {
        System.out.println("TC02- User cannot login with invalid password");
        // Access excel file
        ExcelUtils invalidPass = new ExcelUtils();
        invalidPass.setExcelFile(Constant.Path_InvalidPassword, "Sheet1");
        int numRow = invalidPass.getNumRow();

        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabLogin();
        LoginPage loginPage = new LoginPage();
        String expectedMsg = "Invalid username or password. Please try again.";
        String actualMsg = "";

        for (int i = 1; i <= numRow; i++) {
            loginPage.login(Constant.USERNAME, invalidPass.getCellData(i, 0));
            actualMsg = loginPage.getMessageError();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected ");
        }


    }


}
