package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage{
    private By txtCurrentPassword = By.id("currentPassword");
    private By txtNewPassword = By.id("newPassword");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By lblSuccess = By.xpath("//p[@class = 'message success']");
    private By btnChangePassword =  By.xpath("//input[@value = 'Change Password']");


}
