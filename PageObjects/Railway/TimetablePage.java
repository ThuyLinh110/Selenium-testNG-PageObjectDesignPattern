package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    private String lnkBookticket = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href,'BookTicket')]" ;

    private WebElement getBtnBookTicket(String depart, String arrival) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkBookticket,depart,arrival)));
    }

    public void clickBookTicketLink(String depart, String arrival) {
        WebElementManager.clickToElement(getBtnBookTicket(depart, arrival));
    }
}
