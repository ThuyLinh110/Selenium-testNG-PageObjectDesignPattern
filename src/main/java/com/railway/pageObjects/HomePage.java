package com.railway.pageObjects;

import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By createAccLink = By.xpath("//div[@id='content']//a[contains(@href, 'Register')]");

    private WebElement getCreateAccLink() {
        return Constant.WEBDRIVER.findElement(createAccLink);
    }

    public void clickOnCreateAccLink(){
        WebElementManager.clickToElement(getCreateAccLink());
    }
}
