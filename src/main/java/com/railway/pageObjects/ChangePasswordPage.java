package com.railway.pageObjects;

import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage{
    private By currentPasswordTxt = By.id("currentPassword");
    private By newPasswordTxt = By.id("newPassword");
    private By confirmPasswordTxt = By.id("confirmPassword");
    private By successLabel = By.xpath("//p[@class = 'message success']");
    private By errorLabel =  By.xpath("//p[@class = 'message error']");
    private By changePasswordBtn =  By.xpath("//input[@value = 'Change Password']");


    private WebElement getCurrentPasswordTxt(){return Constant.WEBDRIVER.findElement(currentPasswordTxt);}
    private WebElement getNewPasswordTxt(){return Constant.WEBDRIVER.findElement(newPasswordTxt);}
    private WebElement getConfirmPasswordTxt(){return Constant.WEBDRIVER.findElement(confirmPasswordTxt);}
    private WebElement getMsgSuccess(){return Constant.WEBDRIVER.findElement(successLabel);}
    private WebElement getMsgError(){return Constant.WEBDRIVER.findElement(errorLabel);}

    private WebElement getChangePasswordBtn(){return Constant.WEBDRIVER.findElement(changePasswordBtn);}

    public void FillData(String currentPass, String newPass, String confirmPass){
        getCurrentPasswordTxt().sendKeys(currentPass);
        getNewPasswordTxt().sendKeys(newPass);
        getConfirmPasswordTxt().sendKeys(confirmPass);
    }

    public void clickBtnChangePassword() {
        WebElementManager.clickToElement(getChangePasswordBtn());
    }

    public void changePassword(String currentPass, String newPass, String confirmPass){
        FillData(currentPass, newPass, confirmPass);
        clickBtnChangePassword();
    }

    public String getMessageSuccess(){
        WebElementManager.scrollToElement(getMsgSuccess());
        return getMsgSuccess().getText();
    }
    public String getMessageError(){
        WebElementManager.scrollToElement(getMsgError());
        return getMsgError().getText();
    }

}
