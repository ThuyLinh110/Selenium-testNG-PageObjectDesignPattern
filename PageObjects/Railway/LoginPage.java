package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class LoginPage extends BasePage{
    private By txtUserName = By.xpath("//input[@id='username']");
    private By txtPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@value='Login']");
    private By lnkRegister = By.xpath("//div[@id ='content']//a[@href ='Register.cshtml']");
    private By lnkForgotPassword = By.xpath("//div[@id ='content']//a[@href ='/Account/ForgotPassword.cshtml']");


    //WebElements
    private WebElement getTxtUserName() {return Constant.WEBDRIVER.findElement(txtUserName) ;}
    private WebElement getTxtPassword() {return Constant.WEBDRIVER.findElement(txtPassword) ;}
    private WebElement getBtnLogin() {return Constant.WEBDRIVER.findElement(btnLogin) ;}
    private WebElement getLnkRegister() {return Constant.WEBDRIVER.findElement(lnkRegister) ; }
    private WebElement getLnkForgotPassword() {return Constant.WEBDRIVER.findElement(lnkForgotPassword) ; }



    //Methods

    public void login(String userName, String password)
    {
        getTxtUserName().sendKeys(userName);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }
    public void navigateRegisterLink()
    {
        getLnkRegister().click();
    }
    public void navigateForgotPasswordLink()
    {
        getLnkForgotPassword().click();
    }
}
