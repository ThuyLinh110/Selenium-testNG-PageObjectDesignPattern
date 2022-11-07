package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Constant.Constant;
public class BasePage {


    //Locator of tabs
    private By tabHome = By.xpath("//div[@id ='menu']//a[@href='../'] " );
    private By tabFAQ = By.xpath("//div[@id ='menu']//a[@href='#'] " );
    private By tabContact = By.xpath("//div[@id ='menu']//a[@href='/Page/Contact.cshtml'] " );
    private By tabTimetable = By.xpath("//div[@id ='menu']//a[@href='TrainTimeListPage.cshtml'] " );
    private By tabTicketPrice = By.xpath("//div[@id ='menu']//a[@href='/Page/TrainPriceListPage.cshtml'] " );
    private By tabBookTicket = By.xpath("//div[@id ='menu']//a[@href='/Page/BookTicketPage.cshtml'] " );
    private By tabRegister = By.xpath("//div[@id ='menu']//a[@href='/Account/Register.cshtml'] " );
    private By tabLogin = By.xpath("//div[@id ='menu']//a[@href='/Account/Login.cshtml'] " );
    private By tabMyTicket = By.xpath("//div[@id ='menu']//a[@href='/Page/ManageTicket.cshtml'] " );
    private By tabChangePassword = By.xpath("//div[@id ='menu']//a[@href='/Account/ChangePassword.cshtml'] " );
    private By tabLogout = By.xpath("//div[@id ='menu']//a[@href='/Account/Logout'] " );

    private By msgWelcome = By.xpath("//div[@class = 'account']//strong");




    //Web Elements
    protected WebElement getTabHome() {return Constant.WEBDRIVER.findElement(tabHome) ;}
    protected WebElement getTabFAQ() {return Constant.WEBDRIVER.findElement(tabFAQ) ;}
    protected WebElement getTabContact() {return Constant.WEBDRIVER.findElement(tabContact) ;}
    protected WebElement getTabTimetable() {return Constant.WEBDRIVER.findElement(tabTimetable) ;}
    protected WebElement getTabTicketPrice() {return Constant.WEBDRIVER.findElement(tabTicketPrice) ;}
    protected WebElement getTabBookTicket() {return Constant.WEBDRIVER.findElement(tabBookTicket) ;}
    protected WebElement getTabRegister() {return Constant.WEBDRIVER.findElement(tabRegister) ;}
    protected WebElement getTabLogin() {return Constant.WEBDRIVER.findElement(tabLogin) ;}
    protected WebElement getTabMyTicket() {return Constant.WEBDRIVER.findElement(tabMyTicket) ;}
    protected WebElement getTabChangePassword() {return Constant.WEBDRIVER.findElement(tabChangePassword) ;}
    protected WebElement getTabLogout() {return Constant.WEBDRIVER.findElement(tabLogout) ;}

    protected WebElement getMsgWelcome() { return Constant.WEBDRIVER.findElement(msgWelcome); }




    public WebDriver getWebDriver()
    {
        return Constant.WEBDRIVER;
    }
    public void openPage(String baseUrl)
    {

        Constant.WEBDRIVER.navigate().to(baseUrl);
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
