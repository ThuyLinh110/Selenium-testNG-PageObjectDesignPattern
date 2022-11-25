package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MyTicketPage extends BasePage{

    private String btnCancelByNo = "//tr[td[count(//th[.='No']/preceding-sibling::th)+1][.='%s']]//input[@value='Cancel']";
    private String btnCancelById = "//input[@onclick ='%s']";


}
