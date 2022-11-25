package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    private String lnkBookticket = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href,'BookTicket')]" ;


}
