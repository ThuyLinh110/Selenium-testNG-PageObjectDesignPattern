package Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.WebElementManager;

public class BasePage {
    //Locator of tabs
    private String tabName = "//div[@id ='menu']//span[text()='%s']/..";
    private By lblWelcome = By.xpath("//div[@class = 'account']//strong");
    private By lblNamePage = By.xpath("//h1[@align='center']");

    protected WebElement getTab(String tab) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tabName, tab)));
    }

    public void clickTab(String tab) {
        WebElementManager.clickToElement(getTab(tab));
    }



}
