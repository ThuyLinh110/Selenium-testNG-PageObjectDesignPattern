package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimetablePage extends BasePage{


    private By lnkBookticket(String depart, String arrival){
        return By.xpath("//td[text()='" + depart+"']/following-sibling::td[text()='"+arrival+"']/..//a[contains(@href,'BookTicket')]");
    }

    private WebElement getBtnBookTicket(String depart,String arrival){
        return Constant.WEBDRIVER.findElement(lnkBookticket(depart, arrival));
    }

    public void clickBookTicketLink(String depart, String arrival){
        WebElement link =  getBtnBookTicket(depart,arrival);
        JavascriptExecutor jse = (JavascriptExecutor)Constant.WEBDRIVER;
        jse.executeScript("arguments[0].click()", link);

    }
}
