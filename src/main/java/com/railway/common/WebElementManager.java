package com.railway.common;

import com.railway.constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebElementManager {
    public static void clickToElement(WebElement element){

        scrollToElement(element);
        element.click();

    }
    public static void scrollToElement( WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor)(Constant.WEBDRIVER);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static Alert getAlert(){
        return Constant.WEBDRIVER.switchTo().alert();
    }

    public static boolean checkElementExist(WebElement element) {
        if (element != null) return true;
        return false;
    }
    public static void gotoPreviousPage(){
        Constant.WEBDRIVER.navigate().back();
    }

    public static void waitElement(long timeout)  {
        try {
            Thread.sleep(timeout);
        }
        catch (Exception e)
        {

        }


    }


}
