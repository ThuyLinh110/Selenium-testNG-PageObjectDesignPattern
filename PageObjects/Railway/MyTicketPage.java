package Railway;

import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MyTicketPage extends BasePage{

    private String btnCancelByNo = "//tr[td[count(//th[.='No']/preceding-sibling::th)+1][.='%s']]//input[@value='Cancel']";

    private String btnCancelById = "//input[@onclick ='%s']";
    private WebElement getBtnCancelByValueNo(String no){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelByNo,no)));
    }

    private WebElement getBtnCancelById(String id){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelById,id)));
    }

    public String getIdOfBtnCancel(String no){
        return getBtnCancelByValueNo(no).getAttribute("onclick");
    }

    public void cancelTicketByValueNo(String no){
        WebElementManager.clickToElement(getBtnCancelByValueNo(no));
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean checkCancelTicket(String id) {
        try {
            WebElement btn  = getBtnCancelById(id);
        }
        catch (Exception e) {
            return true;
        }
        return false;
    }

}
