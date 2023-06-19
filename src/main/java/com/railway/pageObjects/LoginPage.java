package com.railway.pageObjects;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By userNameTxt = By.id("username");
    private By passwordTxt = By.id("password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By registerLnk = By.xpath("//div[@id ='content']//a[@href ='Register.cshtml']");
    private By forgotPasswordLnk = By.xpath("//div[@id ='content']//a[@href ='/Account/ForgotPassword.cshtml']");
    private By errorLbl = By.xpath("//p[@class ='message error LoginForm']");
    private By errorUsenameLbl = By.xpath("//li[@class = 'username']//label[@class ='validation-error']");
    private By errorPasswordLbl = By.xpath("//li[@class = 'password']//label[@class ='validation-error']");


    //WebElements
    private WebElement getUserNameTxt() {
        return Constant.WEBDRIVER.findElement(userNameTxt);
    }

    private WebElement getPasswordTxt() {
        return Constant.WEBDRIVER.findElement(passwordTxt);
    }

    private WebElement getLoginBtn() {
        return Constant.WEBDRIVER.findElement(loginBtn);
    }

    private WebElement getRegisterLnk() {
        return Constant.WEBDRIVER.findElement(registerLnk);
    }

    private WebElement getForgotPasswordLnk() {
        return Constant.WEBDRIVER.findElement(forgotPasswordLnk);
    }

    private WebElement getMsgError() {return Constant.WEBDRIVER.findElement(errorLbl); }
    private WebElement getMsgErrorUserName(){return Constant.WEBDRIVER.findElement(errorUsenameLbl); }

    private WebElement getMsgErrorPassword(){return Constant.WEBDRIVER.findElement(errorPasswordLbl);}



    //Methods

    @Step("Fill data to login form")
    public void fillData(String userName, String password) {
        getUserNameTxt().clear();
        getPasswordTxt().clear();
        getUserNameTxt().sendKeys(userName);
        getPasswordTxt().sendKeys(password);

    }
    @Step("Click Login button")
    public void clickBtnLogin(){
        WebElementManager.clickToElement(getLoginBtn());
    }

    public void login(String userName, String password){
        fillData(userName, password);
        clickBtnLogin();
    }

    public String getMessageError() {
        return getMsgError().getText();
    }

    public String getMessageErrorUserName(){
        return  getMsgErrorUserName().getText();
    }

    public String getMessageErrorPassword(){
        return getMsgErrorPassword().getText();
    }

    public void navigateRegisterLink() {
        getRegisterLnk().click();
    }

    public void navigateForgotPasswordLink() {
        getForgotPasswordLnk().click();
    }


}
