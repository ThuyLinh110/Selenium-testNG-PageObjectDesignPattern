package Railway;
import Common.JsonUtils;
import Common.WebElementManager;
import Constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

    private WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    private WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public void FillData(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pid);
    }

    public void clickBtnRegister() {
        WebElementManager.clickToElement(getBtnRegister());
    }

    public void register(String email, String password, String confirmPassword, String pid){
        FillData(email, password, confirmPassword, pid);
        clickBtnRegister();

    }


}
