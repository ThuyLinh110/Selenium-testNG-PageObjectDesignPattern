package com.railway.pageObjects;

import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ForgotPasswordPage extends BasePage{
    private By emailTxt = By.id("email");
    private By sendBtn = By.xpath("////input[@value='Send Instructions']");
    private WebElement getEmailTxt() {
        return Constant.WEBDRIVER.findElement(emailTxt);
    }
    private WebElement getSendBtn() {
        return Constant.WEBDRIVER.findElement(sendBtn);
    }

    public void sendInstructions(String email){
        getEmailTxt().sendKeys(email);
        WebElementManager.clickToElement(getSendBtn());
    }

}
