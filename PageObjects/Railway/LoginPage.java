package Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.WebElementManager;

public class LoginPage extends BasePage {
    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='Login']");

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



}
