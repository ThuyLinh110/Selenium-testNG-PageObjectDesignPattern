package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class LoginPage extends BasePage {
    private By txtUserName = By.xpath("//input[@id='username']");
    private By txtPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@value='Login']");
    private By lnkRegister = By.xpath("//div[@id ='content']//a[@href ='Register.cshtml']");
    private By lnkForgotPassword = By.xpath("//div[@id ='content']//a[@href ='/Account/ForgotPassword.cshtml']");
    private By msgError = By.xpath("//p[@class ='message error LoginForm']");


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
    private WebElement getMsgError()
    {
        return Constant.WEBDRIVER.findElement(msgError);
    }


    //Methods

    public void login(String userName, String password) {
        getTxtUserName().clear();
        getTxtPassword().clear();
        getTxtUserName().sendKeys(userName);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public String getMessageError()
    {
        return getMsgError().getText();
    }

    public void navigateRegisterLink() {
        getLnkRegister().click();
    }

    public void navigateForgotPasswordLink() {
        getLnkForgotPassword().click();
    }
}
