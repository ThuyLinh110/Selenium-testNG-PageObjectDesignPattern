package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ForgotPasswordPage extends BasePage{
    private By txtEmail = By.id("email");
    private By btnSend = By.xpath("////input[@value='Send Instructions']");
    private WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    private WebElement getBtnSend() {
        return Constant.WEBDRIVER.findElement(btnSend);
    }

    public void sendInstructions(String email){
        getTxtEmail().sendKeys(email);
        WebElementManager.clickToElement(getBtnSend());
    }

}
