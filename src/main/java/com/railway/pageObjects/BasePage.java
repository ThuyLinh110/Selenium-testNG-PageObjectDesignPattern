package com.railway.pageObjects;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //Locator of tabs
    private String tabName = "//div[@id ='menu']//span[text()='%s']/..";
    private By welcomeLabel = By.xpath("//div[@class = 'account']//strong");
    private By namePageLabel = By.xpath("//h1[@align='center']");

    //Web Elements
    protected WebElement getTab(String tab) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tabName, tab)));
    }

    protected WebElement getMsgWelcome() {
        return Constant.WEBDRIVER.findElement(welcomeLabel);
    }

    protected WebElement getNamePageLabel() {
        return Constant.WEBDRIVER.findElement(namePageLabel);
    }

    public String getWelcomeMessage() {
        return getMsgWelcome().getText();
    }

    public void clickTab(String tab) {
        WebElementManager.clickToElement(getTab(tab));
    }

    public boolean checkTabDisplay(String tabName) {
        try {
            WebElement tab = getTab(tabName);
            if (tab != null) return true;
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean checkTabNotDisplay(String tabName) {
        return !checkTabDisplay(tabName);
    }

    public boolean checkElementExist(WebElement element)
    {
        return WebElementManager.checkElementExist(element);
    }

    public String getNameTitlePage() {
        return getNamePageLabel().getText();
    }
    public void gotoPreviousPage(){
        WebElementManager.gotoPreviousPage();
    }




}
