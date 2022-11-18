package Railway;

import Common.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends  BaseTest{
    @Test
    public void TC07() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        String expectedMsg = "Thank you for registering your account";
        Log.info("TC07- User can create new account");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register("abcd@gmail.com","12345678","12345678","1234567890");
        Log.info("Step 3 : Enter valid information into all fields");
        Log.info("Step 4 : Click on Register button");
        Assert.assertEquals(registerPage.getMessageSuccess(), expectedMsg, "Message is not displayed as expected");

    }

    @Test
    public void TC10(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Log.info("TC07- User can't create account with 'Confirm password' is not the same with 'Password'");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register("aaa@gmail.com","12345678","12345678900","1234567890");
        Log.info("Step 3 :  Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
        Log.info("Step 4 : Click on Register button");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Error Message is not displayed as expected");
    }
    @Test
    public void TC11(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsgPassword = "Invalid password length.";
        String expectedMsgPID ="Invalid ID length.";
        Log.info("TC11- User can't create account while password and PID fields are empty");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register("bbbb@gmail.com","","","");
        Log.info("Step 3 : Enter valid email address and leave other fields empty");
        Log.info("Step 4 : Click on Register button");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Error Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedMsgPassword, "Error Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedMsgPID, "Error Message is not displayed as expected");

    }

}
