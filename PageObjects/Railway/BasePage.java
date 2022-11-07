package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Constant.Constant;
public class BasePage {


    //Locator of tabs
    protected By tabHome = By.xpath("//div[@id ='menu']//a[@href='../'] " );
    protected By tabFAQ = By.xpath("//div[@id ='menu']//a[@href='#'] " );
    protected By tabContact = By.xpath("//div[@id ='menu']//a[@href='/Page/Contact.cshtml'] " );
    protected By tabTimetable = By.xpath("//div[@id ='menu']//a[@href='TrainTimeListPage.cshtml'] " );
    protected By tabTicketPrice = By.xpath("//div[@id ='menu']//a[@href='/Page/TrainPriceListPage.cshtml'] " );
    protected By tabBookTicket = By.xpath("//div[@id ='menu']//a[@href='/Page/BookTicketPage.cshtml'] " );
    protected By tabRegister = By.xpath("//div[@id ='menu']//a[@href='/Account/Register.cshtml'] " );
    protected By tabLogin = By.xpath("//div[@id ='menu']//a[@href='/Account/Login.cshtml'] " );
    protected By tabMyTicket = By.xpath("//div[@id ='menu']//a[@href='/Page/ManageTicket.cshtml'] " );
    protected By tabChangePassword = By.xpath("//div[@id ='menu']//a[@href='/Account/ChangePassword.cshtml'] " );
    protected By tabLogout = By.xpath("//div[@id ='menu']//a[@href='/Account/Logout'] " );

    protected By msgWelcome = By.xpath("//div[@class = 'account']//strong");




    //Web Elements
    private WebElement getTabHome() {return Constant.WEBDRIVER.findElement(tabHome) ;}
    private WebElement getTabFAQ() {return Constant.WEBDRIVER.findElement(tabFAQ) ;}
    private WebElement getTabContact() {return Constant.WEBDRIVER.findElement(tabContact) ;}
    private WebElement getTabTimetable() {return Constant.WEBDRIVER.findElement(tabTimetable) ;}
    private WebElement getTabTicketPrice() {return Constant.WEBDRIVER.findElement(tabTicketPrice) ;}
    private WebElement getTabBookTicket() {return Constant.WEBDRIVER.findElement(tabBookTicket) ;}
    private WebElement getTabRegister() {return Constant.WEBDRIVER.findElement(tabRegister) ;}
    private WebElement getTabLogin() {return Constant.WEBDRIVER.findElement(tabLogin) ;}
    private WebElement getTabMyTicket() {return Constant.WEBDRIVER.findElement(tabMyTicket) ;}
    private WebElement getTabChangePassword() {return Constant.WEBDRIVER.findElement(tabChangePassword) ;}
    private WebElement getTabLogout() {return Constant.WEBDRIVER.findElement(tabLogout) ;}

    private WebElement getMsgWelcome() { return Constant.WEBDRIVER.findElement(msgWelcome); }




    public WebDriver getWebDriver()
    {
        return Constant.WEBDRIVER;
    }
    public void openPage()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
    public void closePage()
    {
        Constant.WEBDRIVER.close();

    }
    public String getWelcomeMessage()
    {
        return getMsgWelcome().getText();
    }
    public void clickTabHome()
    {
        getTabHome().click();
    }
    public void clickTabFAQ()
    {
        getTabFAQ().click();
    }
    public void clickTabContact()
    {
        getTabContact().click();
    }
    public void clickTabTimetable()
    {
        getTabTimetable().click();
    }
    public void clickTabTicketPrice()
    {
        getTabTicketPrice().click();
    }
    public void clickTabBookTicket()
    {
        getTabBookTicket().click();
    }
    public void clickTabRegister()
    {
        getTabRegister().click();
    }
    public void clickTabLogin()
    {
        getTabLogin().click();
    }
    public void clickTabMyTicket()
    {
        getTabMyTicket().click();
    }
    public void clickTabChangePassword()
    {
        getTabChangePassword().click();
    }
    public void clickTabLogout()
    {
        getTabLogout().click();
    }
}
