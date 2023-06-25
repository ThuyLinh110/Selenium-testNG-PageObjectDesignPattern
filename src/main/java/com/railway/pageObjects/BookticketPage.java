package com.railway.pageObjects;

import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BookticketPage extends BasePage {
    private By dateDdl = By.name("Date");
    private By departDdl = By.name("DepartStation");
    private By arriveDdl = By.name("ArriveStation");
    private By seatTypeDdl = By.name("SeatType");
    private By ticketAmountDdl = By.name("TicketAmount");
    private By bookTicketBtn = By.xpath("//input[@value = 'Book ticket']");
    private String valueByHeader = "//td[count(//th[.='%s']/preceding-sibling::th)+1]" ;
    private By errorMsg = By.xpath("//p[@class = 'message error']");

    private Select getDateDdl() {
        return new Select(Constant.WEBDRIVER.findElement(dateDdl));
    }

    private Select getDepartDdl() {
        return new Select(Constant.WEBDRIVER.findElement(departDdl));
    }

    private Select getArriveDdl() {
        return new Select(Constant.WEBDRIVER.findElement(arriveDdl));
    }

    private Select getSeatTypeDdl() {
        return new Select(Constant.WEBDRIVER.findElement(seatTypeDdl));
    }

    private Select getTicketAmountDdl() {
        return new Select(Constant.WEBDRIVER.findElement(ticketAmountDdl));
    }

    private WebElement getBookTicketBtn() {
        return Constant.WEBDRIVER.findElement(bookTicketBtn);
    }

    private WebElement getValueTicketByHeader(String header) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(valueByHeader, header)));
    }
    private WebElement getErrorMsg(){
        return Constant.WEBDRIVER.findElement(errorMsg);
    }

    public void fillDataTicket(int indexDate, String depart, String arrive, String seat, String amount)  {
        getDateDdl().selectByIndex(indexDate);
        getDepartDdl().selectByVisibleText(depart);
        WebElementManager.waitElement(1000);
        getArriveDdl().selectByVisibleText(arrive);
        getSeatTypeDdl().selectByVisibleText(seat);
        getTicketAmountDdl().selectByVisibleText(amount);
    }

    public void clickBookTicketBtn() {
        WebElementManager.clickToElement(getBookTicketBtn());
    }

    public String getValueOfTicketByHeader(String header) {
        return getValueTicketByHeader(header).getText();
    }

    public String getSelectedDate() {
        return getDateDdl().getFirstSelectedOption().getText();
    }

    public String getSelectedDepart() {
        return getDepartDdl().getFirstSelectedOption().getText();
    }

    public String getSelectedArrive() {
        return getArriveDdl().getFirstSelectedOption().getText();
    }

    public String getSelectedSeatType() {
        return getSeatTypeDdl().getFirstSelectedOption().getText();
    }
    public List<String> getAllDepartDate(){
        List<String> dateList = new ArrayList<>();
        List<WebElement> dateOptions = getDateDdl().getOptions();
        for (WebElement date : dateOptions) {
            dateList.add(date.getText());
        }
        return dateList;
    }
    public List<String> getAllDepartStation(){
        List<String> dateList = new ArrayList<>();
        List<WebElement> dateOptions = getDepartDdl().getOptions();
        for (WebElement date : dateOptions) {
            dateList.add(date.getText());
        }
        return dateList;
    }
    public List<String> getAllArriveStation(){
        List<String> dateList = new ArrayList<>();
        List<WebElement> dateOptions = getArriveDdl().getOptions();
        for (WebElement date : dateOptions) {
            dateList.add(date.getText());
        }
        return dateList;
    }
    public List<String> getAllSeatType(){
        List<String> dateList = new ArrayList<>();
        List<WebElement> dateOptions = getSeatTypeDdl().getOptions();
        for (WebElement date : dateOptions) {
            dateList.add(date.getText());
        }
        return dateList;
    }
    public List<String> getAllTicketAmount(){
        List<String> dateList = new ArrayList<>();
        List<WebElement> dateOptions = getTicketAmountDdl().getOptions();
        for (WebElement date : dateOptions) {
            dateList.add(date.getText());
        }
        return dateList;
    }
    public String getErrorMessage(){
        return getErrorMsg().getText();
    }

}
