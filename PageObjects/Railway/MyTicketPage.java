package Railway;
import Common.WebElementManager;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MyTicketPage extends BasePage{


    private By btnCancel = By.xpath("//input[@value ='Cancel']");
    private By lblNote = By.xpath("//div[@class='message']/li[1]");

    private By lblError= By.xpath("//div[@class = 'error message']");
    private By rowTicket = By.xpath("//table[@class='MyTable']//tr");
    private WebElement getlblNote(){
        return Constant.WEBDRIVER.findElement(lblNote);
    }

    private WebElement getlblError(){
        return Constant.WEBDRIVER.findElement(lblError);
    }
    private List<WebElement>getAllTicket(){
        return Constant.WEBDRIVER.findElements(rowTicket);
    }

    private List<WebElement> getBtnCancel()
    {
        return Constant.WEBDRIVER.findElements(btnCancel);
    }


    public String getLblNote(){
        return getlblNote().getText();
    }

    public String getLblError(){
        return getlblError().getText();
    }

    public int getNumTicket(){
        return getAllTicket().size() -1  ;
    }

    public void cancelTicket(){
        WebElementManager.clickToElement(getBtnCancel().get(0));
        WebElementManager.getAlert().accept();

    }




}
