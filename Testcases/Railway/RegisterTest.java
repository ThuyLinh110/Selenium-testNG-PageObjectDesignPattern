package Railway;
import Common.JsonUtils;
import Common.Log;
import Constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends  BaseTest{

    @Test
    public void TC07() {
/**  Load new data from newAccountList for register account
 *   After register successfully, remove registed data from newAccountList
 *   Insert registed data to existedAccountList
 */
//      Load data from *.json
        JSONArray newAccountList = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
        JSONArray existedAccountList = JsonUtils.getJSONList(Constant.EXISTED_ACC_DATA_PATH);
        JSONObject newAccount = JsonUtils.getJSONObjectByIndex(newAccountList,0);
        String userName = newAccount.get("User Name").toString();
        String password = newAccount.get("Password").toString();
        String PID = newAccount.get("PID").toString();
        String expectedMsg = "You're here";
//      PageObject contructor
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
//      Excute Testcase
        Log.info("TC07- User can create new account");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register(userName, password, password,PID);
        Log.info("Step 3 : Enter valid information into all fields");
        Log.info("Step 4 : Click on Register button");
//      After registing successfully, remove data from newAccountList and insert registed data to existedAccountList
        newAccountList.remove(0);
        JsonUtils.setJSONList(Constant.NEW_ACC_DATA_PATH, newAccountList);
        JSONObject account = new JSONObject();
        account.put("User Name", userName);
        account.put("Password", password);
        existedAccountList.add(account);
        JsonUtils.setJSONList(Constant.EXISTED_ACC_DATA_PATH, existedAccountList);
        Assert.assertEquals(registerPage.getMessageSuccess(), expectedMsg, "Message is not displayed as expected");
        Log.info("Step 5 : Verify that success message appears.");

    }
    @Test
    public void TC10(){
//      Load data from *.json
        JSONArray newAccountList = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
        JSONObject newAccount = JsonUtils.getJSONObjectByIndex(newAccountList,0);
        String userName = newAccount.get("User Name").toString();
        String password = newAccount.get("Password").toString();
        String PID = newAccount.get("PID").toString();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
//      PageObject Constructor
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
//      Excute Testcase
        Log.info("TC07- User can't create account with 'Confirm password' is not the same with 'Password'");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register(userName,password,password+"123",PID);
        Log.info("Step 3 : Register with all valid fields except 'Confirm password' is not the same with 'Password'");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Error Message is not displayed as expected");
        Log.info("Step 4 : Verify that error message appear");
    }
    @Test
    public void TC11(){
//      Load data from *.json
        JSONArray newAccountList = JsonUtils.getJSONList(Constant.NEW_ACC_DATA_PATH);
        JSONObject newAccount = JsonUtils.getJSONObjectByIndex(newAccountList,0);
        String userName = newAccount.get("User Name").toString();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsgPassword = "Invalid password length";
        String expectedMsgPID ="Invalid ID length";
//      PageObject Constructor
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
//      Excute Testcase
        Log.info("TC11- User can't create account while password and PID fields are empty");
        Log.info("Step 1 : Open Railway");
        homePage.clickTab("Register");
        Log.info("Step 2 : Click on Register tab");
        registerPage.register(userName,"","","");
        Log.info("Step 3 : Register with valid email and empty other fields");
        Assert.assertEquals(registerPage.getMessageError(), expectedMsg, "Error Message is not displayed as expected");
        Log.info("Step 4 : Verify that error message appears");
        Assert.assertEquals(registerPage.getLabelErrorPassword(), expectedMsgPassword, "Error Message is not displayed as expected");
        Assert.assertEquals(registerPage.getLabelErrorPID(), expectedMsgPID, "Error Message is not displayed as expected");
        Log.info("Step 5 : Verify that error message appears next to invalid field");

    }

}
