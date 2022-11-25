package Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.WebElementManager;

public class LoginPage extends BasePage {
    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='Login']");
    private By lnkRegister = By.xpath("//div[@id ='content']//a[@href ='Register.cshtml']");
    private By lnkForgotPassword = By.xpath("//div[@id ='content']//a[@href ='/Account/ForgotPassword.cshtml']");
    private By lblError = By.xpath("//p[@class ='message error LoginForm']");
    private By lblErrorUsename = By.xpath("//li[@class = 'username']//label[@class ='validation-error']");
    private By lblErrorPassword = By.xpath("//li[@class = 'password']//label[@class ='validation-error']");



}
