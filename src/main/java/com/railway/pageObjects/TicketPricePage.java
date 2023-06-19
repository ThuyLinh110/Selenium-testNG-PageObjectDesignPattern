package com.railway.pageObjects;

import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketPricePage extends BasePage{
    private String checkPriceLnk = "//li[text() = '%s to %s']/../..//a" ;
    private By ticketPriceTbl = By.xpath("//table[@class = 'MyTable MedTable']");
    private By titleTicketPriceTable =  By.xpath("//tr[@class = 'TableSmallHeader']/th");
    private By priceLnkList = By.xpath("//a[contains(@href,'TicketPrice')]");
    private String priceLnkByIndex = "(//a[contains(@href,'TicketPrice')])[%d]";
    private String titleTicketByIndex = "(//a[contains(@href,'TicketPrice')])[%d]/../..//li[@class='ListSmall']";
    private By bookTicketBtnList = By.xpath("//table//a[contains(@href,'BookTicket')]");
    private String bookTicketBtnByIndex = "(//table//a[contains(@href,'BookTicket')])[%d]";
    private String seatTypeByIndex = "(//table//a[contains(@href,'BookTicket')])[%d]/../../td[2]";


    private WebElement getLnkCheckPrice(String depart, String arrival) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(checkPriceLnk,depart,arrival)));
    }
    private WebElement getTicketPriceTbl() {
        return Constant.WEBDRIVER.findElement(ticketPriceTbl);
    }
    private WebElement getTitleTicketPrice() {
        return Constant.WEBDRIVER.findElement(titleTicketPriceTable);
    }
    private WebElement getPriceLnkByIndex(int i) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(priceLnkByIndex,i)));
    }
    private WebElement getBookTicketBtnByIndex(int i) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(bookTicketBtnByIndex,i)));
    }
    private WebElement getSeatTypeByIndex(int i) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(seatTypeByIndex,i)));
    }
    private WebElement getTitleTicketByIndex(int i) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(titleTicketByIndex,i)));
    }

    private List<WebElement> getPriceLnkList() {
        return Constant.WEBDRIVER.findElements(priceLnkList);
    }
    private List<WebElement> getBookTicketBtnList() {
        return Constant.WEBDRIVER.findElements(bookTicketBtnList);
    }

    public void clickCheckPriceLink(String depart, String arrival) {
        WebElementManager.clickToElement(getLnkCheckPrice(depart, arrival));
    }
    public void clickBookTicketBtn(int i) {
        WebElementManager.clickToElement(getBookTicketBtnByIndex(i));
    }

    public boolean checkTableTicketPriceDisplay(){
        return WebElementManager.checkElementExist(getTicketPriceTbl());
    }

    public String getTicketTitle(){
        return getTitleTicketPrice().getText();
    }
    public void clickPriceLnkByIndex(int i) {
        WebElementManager.clickToElement(getPriceLnkByIndex(i));
    }
    public int getNumberPriceTicket() {
        return getPriceLnkList().size();
    }
    public String getTitleTicketPriceByIndex(int i){
        return "Ticket price from "+getTitleTicketByIndex(i).getText();
    }
    public String getDepartureByIndex(int i) {
        String title = getTitleTicketByIndex(i).getText();
        return title.substring(0, title.indexOf(" to"));
    }
    public String getArrivalByIndex(int i) {
        String title = getTitleTicketByIndex(i).getText();
        return title.substring(title.indexOf("to ")+3);
    }
    public int getNumberBookTicketBtn(){
        return getBookTicketBtnList().size();
    }
    public String getSeatType(int i) {
        return getSeatTypeByIndex(i).getText();
    }


}
