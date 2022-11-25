package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookticketPage extends BasePage {
    private By ddlDate = By.name("Date");
    private By ddlDepart = By.name("DepartStation");
    private By ddlArrive = By.name("ArriveStation");
    private By ddlSeatType = By.name("SeatType");
    private By ddlTicketAmount = By.name("TicketAmount");
    private By btnBookTicket = By.xpath("//input[@value = 'Book ticket']");
    private String valueByHeader = "//td[count(//th[.='%s']/preceding-sibling::th)+1]" ;


}
