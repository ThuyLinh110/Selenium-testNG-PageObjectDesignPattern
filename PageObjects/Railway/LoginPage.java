package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.WebElementManager;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='Login']");
    private By lnkRegister = By.xpath("//div[@id ='content']//a[@href ='Register.cshtml']");
    private By lnkForgotPassword = By.xpath("//div[@id ='content']//a[@href ='/Account/ForgotPassword.cshtml']");
    private By lblError = By.xpath("//p[@class ='message error LoginForm']");
    private By lblErrorUsename = By.xpath("//li[@class = 'username']//label[@class ='validation-error']");
    private By lblErrorPassword = By.xpath("//li[@class = 'password']//label[@class ='validation-error']");


    //WebElements
    private WebElement getTxtUserName() {
        return Constant.WEBDRIVER.findElement(txtUserName);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    private WebElement getLnkRegister() {
        return Constant.WEBDRIVER.findElement(lnkRegister);
    }

    private WebElement getLnkForgotPassword() {
        return Constant.WEBDRIVER.findElement(lnkForgotPassword);
    }

    private WebElement getMsgError() {return Constant.WEBDRIVER.findElement(lblError); }
    private WebElement getMsgErrorUserName(){return Constant.WEBDRIVER.findElement(lblErrorUsename); }

    private WebElement getMsgErrorPassword(){return Constant.WEBDRIVER.findElement(lblErrorPassword);}

    //Methods

    public void FillData(String userName, String password) {
        getTxtUserName().clear();
        getTxtPassword().clear();
        getTxtUserName().sendKeys(userName);
        getTxtPassword().sendKeys(password);

    }

    public void clickBtnLogin(){
        WebElementManager.clickToElement(getBtnLogin());
    }

    public void login(String userName, String password){
        FillData(userName, password);
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
        getLnkRegister().click();
    }

    public void navigateForgotPasswordLink() {
        getLnkForgotPassword().click();
    }

}
