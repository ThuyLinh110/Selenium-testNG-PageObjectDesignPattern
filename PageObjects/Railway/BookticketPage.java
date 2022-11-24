package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class BookticketPage extends BasePage {
    private By ddlDate = By.name("Date");
    private By ddlDepart = By.name("DepartStation");
    private By ddlArrive = By.name("ArriveStation");
    private By ddlSeatType = By.name("SeatType");
    private By ddlTicketAmount = By.name("TicketAmount");
    private By btnBookTicket = By.xpath("//input[@value = 'Book ticket']");
    private String valueByHeader = "//td[count(//th[.='%s']/preceding-sibling::th)+1]" ;

    private Select getDdlDate() {
        return new Select(Constant.WEBDRIVER.findElement(ddlDate));
    }

    private Select getDdlDepart() {
        return new Select(Constant.WEBDRIVER.findElement(ddlDepart));
    }

    private Select getDdlArrive() {
        return new Select(Constant.WEBDRIVER.findElement(ddlArrive));
    }

    private Select getDdlSeatType() {
        return new Select(Constant.WEBDRIVER.findElement(ddlSeatType));
    }

    private Select getDdlTicketAmount() {
        return new Select(Constant.WEBDRIVER.findElement(ddlTicketAmount));
    }

    private WebElement getBtnBookticket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    private WebElement getValueTicketByHeader(String header) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(valueByHeader, header)));
    }

    public void FillDataTicket(int indexDate, String depart, String arrive, String seat, String amount) {
        getDdlDate().selectByIndex(indexDate);
        getDdlDepart().selectByVisibleText(depart);
        getDdlArrive().selectByVisibleText(arrive);
        getDdlSeatType().selectByVisibleText(seat);
        getDdlTicketAmount().selectByVisibleText(amount);
    }

    public void clickBtnBookticket() {
        WebElementManager.clickToElement(getBtnBookticket());
    }

    public String getValueOfTicketByHeader(String header) {
        return getValueTicketByHeader(header).getText();
    }

    public String getSelectedDate() {
        return getDdlDate().getFirstSelectedOption().getText();
    }

    public String getSelectedDepart() {
        return getDdlDepart().getFirstSelectedOption().getText();
    }

    public String getSelectedArrive() {
        return getDdlArrive().getFirstSelectedOption().getText();
    }

}
