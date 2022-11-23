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

    private WebElement getTxtCurrentPassword(){return Constant.WEBDRIVER.findElement(txtCurrentPassword);}
    private WebElement getTxtNewPassword(){return Constant.WEBDRIVER.findElement(txtNewPassword);}
    private WebElement getTxtConfirmPassword(){return Constant.WEBDRIVER.findElement(txtConfirmPassword);}
    private WebElement getMsgSuccess(){return Constant.WEBDRIVER.findElement(lblSuccess);}
    private WebElement getBtnChangePassword(){return Constant.WEBDRIVER.findElement(btnChangePassword);}

    public void FillData(String currentPass, String newPass, String confirmPass){
        getTxtCurrentPassword().sendKeys(currentPass);
        getTxtNewPassword().sendKeys(newPass);
        getTxtConfirmPassword().sendKeys(confirmPass);
    }

    public void clickBtnChangePassword() {
        WebElementManager.clickToElement(getBtnChangePassword());
    }

    public void changePassword(String currentPass, String newPass, String confirmPass){
        FillData(currentPass, newPass, confirmPass);
        clickBtnChangePassword();
    }

    public String getMessageSuccess(){
        WebElementManager.scrollToElement(getMsgSuccess());
        return getMsgSuccess().getText();
    }

}
