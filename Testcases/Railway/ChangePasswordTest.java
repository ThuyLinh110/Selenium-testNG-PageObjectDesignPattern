package Railway;

import Common.Log;
import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest{

    @Test
    public void TC09() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        String newPass = Utilities.getGenerateString(10);
        String expectedMsg = "Your password has been updated!";
        Log.info("TC09- User can change password");
        Log.info("Step 1 : Open Railway ");
        homePage.clickTab("Login");
        loginPage.FillData(Constant.USERNAME, Constant.PASSWORD);
        loginPage.clickBtnLogin();
        Log.info("Step 2 : Login with valid account");
        loginPage.clickTab("Change password");
        Log.info("Step 3 : Click Change Password tab");
        changePasswordPage.FillData(Constant.PASSWORD, newPass, newPass);
        Log.info("Step 4 :Fill valid data into all fields");
        changePasswordPage.clickBtnChangePassword();
        Log.info("Step 4 : Click ChangePassword button");
        Utilities.setDataToConfig("config.properties", "password", newPass);
        Assert.assertEquals(changePasswordPage.getMessageSuccess(), expectedMsg, "Welcome message is not displayed as expected ");
    }
}
