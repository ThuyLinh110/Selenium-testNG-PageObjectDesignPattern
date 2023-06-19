package com.railway.pageObjects;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TimetablePage extends BasePage {
    private String bookTicketLnk = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href,'BookTicket')]" ;
    private String ticketPriceLnk = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href,'TicketPrice')]" ;

    private By ticketPriceLnkList = By.xpath("(//table//a[contains(@href,'TicketPrice')])");
    private By bookTicketLnkList = By.xpath("(//table//a[contains(@href,'BookTicket')])");
    private String dynamicTicketPriceLnk = "(//table//a[contains(@href,'TicketPrice')])[%d]";
    private String dynamicBookTicketLnk = "(//table//a[contains(@href,'BookTicket')])[%d]";
    private String dynamicTicketValueByHeaderAndCell = "(//td[count(//th[.='%s']/preceding-sibling::th)+1])[%d]";
    private String ticketValueByHeaderList = "(//td[count(//th[.='%s']/preceding-sibling::th)+1])";

    private By tableHeaderList = By.xpath("//tr[@class='TableSmallHeader']/th");


    private WebElement getBtnBookTicket(String depart, String arrival) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(bookTicketLnk,depart,arrival)));
    }
    private WebElement getBtnTicketPrice(String depart, String arrival) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(ticketPriceLnk,depart,arrival)));
    }
    private WebElement getDynamicTicketPriceLnk(int i){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dynamicTicketPriceLnk,i)));
    }
    private WebElement getDynamicBookTicketLnk(int i){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dynamicBookTicketLnk,i)));
    }
    private WebElement getDynamicTicketStationName (String station, int i) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dynamicTicketValueByHeaderAndCell,station,i)));
    }

    private List<WebElement> getTicketPriceLnkList(){
        return Constant.WEBDRIVER.findElements(ticketPriceLnkList);
    }
    private List<WebElement> getBookTicketLnkList(){
        return Constant.WEBDRIVER.findElements(bookTicketLnkList);
    }

    private List<WebElement> getTicketHeaderList() {
        return Constant.WEBDRIVER.findElements(tableHeaderList);
    }
    private List<WebElement> getTicketValueByHeaderList(String header) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(ticketValueByHeaderList, header)));
    }
    public void clickBookTicketLink(String depart, String arrival) {
        WebElementManager.clickToElement(getBtnBookTicket(depart, arrival));
    }
    public void clickTicketPriceLink(String depart, String arrival) {
        WebElementManager.clickToElement(getBtnTicketPrice(depart, arrival));
    }
    public void clickDynamicTicketPriceLink(int i) {
        WebElementManager.clickToElement(getDynamicTicketPriceLnk(i));
    }
    public void clickDynamicBookTicketLink(int i) {
        WebElementManager.clickToElement(getDynamicBookTicketLnk(i ));
    }
    public String getDynamicTitleTicket(int i) {
        String depart = getDynamicDepart(i);
        String arrive = getDynamicArrive(i);
        return "Ticket price from " + depart + " to " + arrive;
    }
    public int getNumberTicketPriceLnk(){
        return getTicketPriceLnkList().size();
    }
    public int getNumberBookTicketLnk(){
        return getBookTicketLnkList().size();
    }
    public String getDynamicDepart(int i){
        return getDynamicTicketStationName("Depart Station",i).getText();

    }
    public String getDynamicArrive(int i){
        return getDynamicTicketStationName("Arrive Station",i).getText();
    }

    public String getDynamicTicketValueByHeaderAndCell(String header, int i){
        return getDynamicTicketStationName(header,i).getText();
    }

    public List<String> getTableHeaderList() {
        List<String> headerList = new ArrayList<>();
        List<WebElement> headerElementList = getTicketHeaderList();
        for (WebElement header: headerElementList) {
            headerList.add(header.getText());
        }
        return headerList;
    }
    public List<String> getAllTicketValueByHeader(String header){
        List<String> ticketValueList = new ArrayList<>();
        List<WebElement> ticketValueElementList = getTicketValueByHeaderList(header);
        for (WebElement ticketValue: ticketValueElementList) {
            ticketValueList.add(ticketValue.getText());
        }
        return ticketValueList;
    }
}
