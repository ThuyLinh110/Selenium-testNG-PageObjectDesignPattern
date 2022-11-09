package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage{
    private By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private By msgSuccess = By.xpath("//p[@class = 'message success']");

    private By btnChangePassword =  By.xpath("//input[@value = 'Change Password']");

    private WebElement getTxtCurrentPassword(){return Constant.WEBDRIVER.findElement(txtCurrentPassword);}
    private WebElement getTxtNewPassword(){return Constant.WEBDRIVER.findElement(txtNewPassword);}
    private WebElement getTxtConfirmPassword(){return Constant.WEBDRIVER.findElement(txtConfirmPassword);}
    private WebElement getMsgSuccess(){return Constant.WEBDRIVER.findElement(msgSuccess);}
    private WebElement getBtnChangePassword(){return Constant.WEBDRIVER.findElement(btnChangePassword);}

    public void changePassword(String currentPass, String newPass, String confirmPass){
        getTxtCurrentPassword().sendKeys(currentPass);
        getTxtNewPassword().sendKeys(newPass);
        getTxtConfirmPassword().sendKeys(confirmPass);
        getBtnChangePassword().click();
    }

    public String getMessageSuccess(){
        return getMsgSuccess().getText();
    }
}
