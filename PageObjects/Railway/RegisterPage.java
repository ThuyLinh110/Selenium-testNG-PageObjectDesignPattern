package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("password");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By txtPID = By.id("pid");
    private By btnRegister = By.xpath("//input[@value= 'Register']");
    private By msgError = By.xpath("//p[@class='message error']");
    private By lblErrorEmail = By.xpath("//li[@class='email']//label[@class='validation-error']");
    private By lblErrorPassword = By.xpath("//li[@class='password']//label[@class='validation-error']");
    private By lblErrorConfirmPassword = By.xpath("//li[@class='confirm-password']//label[@class='validation-error']");
    private By lblErrorPID = By.xpath("//li[@class='pid-number']//label[@class='validation-error']");
    private By lblRegisterSuccess = By.xpath("//div[@id = 'content']/p");




}
