package com.railway.pageObjects;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private By emailTxt = By.id("email");
    private By passwordTxt = By.id("password");
    private By confirmPasswordTxt = By.id("confirmPassword");
    private By PIDTxt = By.id("pid");
    private By registerBtn = By.xpath("//input[@value= 'Register']");
    private By msgError = By.xpath("//p[@class='message error']");
    private By errorEmailLabel = By.xpath("//li[@class='email']//label[@class='validation-error']");
    private By errorPasswordLabel = By.xpath("//li[@class='password']//label[@class='validation-error']");
    private By errorConfirmPasswordLabel = By.xpath("//li[@class='confirm-password']//label[@class='validation-error']");
    private By errorPIDLabel = By.xpath("//li[@class='pid-number']//label[@class='validation-error']");
    private By registerSuccessLabel = By.xpath("//div[@id = 'content']/p");

    private By loginLink = By.xpath("//div[@id='content']//a[contains(@href, 'Login')]");


    private WebElement getEmailTxt() {
        return Constant.WEBDRIVER.findElement(emailTxt);
    }

    private WebElement getPasswordTxt() {
        return Constant.WEBDRIVER.findElement(passwordTxt);
    }

    private WebElement getConfirmPasswordTxt() {
        return Constant.WEBDRIVER.findElement(confirmPasswordTxt);
    }

    private WebElement getPIDTxt() {
        return Constant.WEBDRIVER.findElement(PIDTxt);
    }

    private WebElement getRegisterBtn() {
        return Constant.WEBDRIVER.findElement(registerBtn);
    }

    private WebElement getMsgError() {
        return Constant.WEBDRIVER.findElement(msgError);
    }

    private WebElement getErrorEmailLabel() {
        return Constant.WEBDRIVER.findElement(errorEmailLabel);
    }

    private WebElement getErrorPasswordLabel() {
        return Constant.WEBDRIVER.findElement(errorPasswordLabel);
    }

    private WebElement getErrorPIDLabel() {
        return Constant.WEBDRIVER.findElement(errorPIDLabel);
    }

    private WebElement getErrorConfirmPasswordLabel() {
        return Constant.WEBDRIVER.findElement(errorConfirmPasswordLabel);
    }

    private WebElement getMsgRegisterSuccess() {
        return Constant.WEBDRIVER.findElement(registerSuccessLabel);
    }

    private WebElement getLoginLink() {
        return Constant.WEBDRIVER.findElement(loginLink);
    }


    public void FillData(String email, String password, String confirmPassword, String pid) {
        getEmailTxt().sendKeys(email);
        getPasswordTxt().sendKeys(password);
        getConfirmPasswordTxt().sendKeys(confirmPassword);
        getPIDTxt().sendKeys(pid);

    }

    public void clickBtnRegister() {
        WebElementManager.clickToElement(getRegisterBtn());
    }

    public void register(String email, String password, String confirmPassword, String pid){
        FillData(email, password, confirmPassword, pid);
        clickBtnRegister();
    }
    public void clickLoginLink() {
        WebElementManager.clickToElement(getLoginLink());
    }


    public String getMessageSuccess() {
        return getMsgRegisterSuccess().getText();
    }

    public String getMessageError() {
        return getMsgError().getText();
    }

    public String getLabelErrorEmail() {
        return getErrorEmailLabel().getText();
    }

    public String getLabelErrorPassword() {
        return getErrorPasswordLabel().getText();
    }

    public String getLabelErrorConfirmPassword() {
        return getErrorConfirmPasswordLabel().getText();
    }

    public String getLabelErrorPID() {
        return getErrorPIDLabel().getText();
    }

}
