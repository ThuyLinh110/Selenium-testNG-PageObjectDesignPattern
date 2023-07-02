package com.railway.pageObjects;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MyTicketPage extends BasePage{
    private String cancelByNoBtn = "//tr[td[count(//div[@class = 'DivCenter']//th[.='No']/preceding-sibling::th)+1][.='%s']]//input[@value='Cancel']";
    private String cancelByIdBtn = "//input[@onclick ='%s']";
    private String deleteByNoBtn = "//tr[td[count(//div[@class = 'DivCenter']//th[.='No']/preceding-sibling::th)+1][.='%s']]//input[@value='Delete']";
    private String ticketValuesByHeader = "//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[.='%s']/preceding-sibling::th)+1]";
    private By ticketRecordList = By.xpath("//table[@class = 'MyTable']//tr");
    private By ticketHeaderList = By.xpath("//tr[@class='TableSmallHeader']/th");
    private By ticketTable = By.xpath("//table[@class = 'MyTable']");
    private By noteMsg = By.xpath("//div[@class='message']//li");
    private String ticketByStatus = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][.='%s']]";
    private String ticketAmountByStatusAndHeader = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][.='%s']]//td[count(//div[@class = 'DivCenter']//th[.='%s']/preceding-sibling::th)+1]";
    private String ticketByAllHeader = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Depart Station']/preceding-sibling::th)+1][contains(text(),'%s')] and td[count(//div[@class = 'DivCenter']//th[.='Arrive Station']/preceding-sibling::th)+1][contains(text(),'%s')] and td[count(//div[@class = 'DivCenter']//th[.='Seat Type']/preceding-sibling::th)+1][contains(text(),'%s')] and td[count(//div[@class = 'DivCenter']//th[.='Depart Date']/preceding-sibling::th)+1][contains(text(),'%s')] and td[count(//div[@class = 'DivCenter']//th[.='Book Date']/preceding-sibling::th)+1][contains(text(),'%s')] and td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][contains(text(),'%s')] and td[count(//div[@class = 'DivCenter']//th[.='Amount']/preceding-sibling::th)+1][contains(text(),'%s')]]";
    private String operationButtonByStatus = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][.='%s']]//td[count(//div[@class = 'DivCenter']//th[.='Operation']/preceding-sibling::th)+1]//input";
    private By filterTable = By.xpath("//div[@class= 'Filter']//table");
    private By dateFilter = By.name("FilterDpDate");
    private String filterByHeader = "//div[@class='Filter']//td[count(//div[@class='Filter']//th[.='%s']/preceding-sibling::th)+1]//select";
    private By applyFilterButton = By.xpath("//input[@type='submit']");
    private By filterHeaders = By.xpath("//div[@class='Filter']//th");


    private WebElement getBtnCancelByValueNo(String no){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(cancelByNoBtn,no)));
    }
    private WebElement getBtnDeleteByValueNo(String no){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(deleteByNoBtn,no)));
    }
    private WebElement getBtnCancelById(String id){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(cancelByIdBtn,id)));
    }
    private WebElement getTicketTable () {
        return Constant.WEBDRIVER.findElement(ticketTable);
    }
    private List<WebElement> getTicketRecordList() {
        return Constant.WEBDRIVER.findElements(ticketRecordList);
    }
    private List<WebElement> getTicketHeaderList() {
        return Constant.WEBDRIVER.findElements(ticketHeaderList);
    }

    private WebElement getNoteMsg() {
        return Constant.WEBDRIVER.findElement(noteMsg);
    }

    private WebElement getFilterTable() {
        return Constant.WEBDRIVER.findElement(filterTable);
    }

    private List<WebElement> getAllTicketValuesByHeader(String header) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(ticketValuesByHeader, header)));
    }
    private List<WebElement> getTicketByStatusAndHeader(String status, String header) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(ticketAmountByStatusAndHeader, status, header)));
    }
    private List<WebElement> getTicketsByStatus(String status) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(ticketByStatus, status)));
    }
    private List<WebElement> getOperationButtonByStatus(String status) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(operationButtonByStatus, status)));
    }
    private List<WebElement> getTicketByAllHeader(String departStation, String arriveStation, String seatType, String departDate, String bookDate, String status, String amount ) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format(ticketByAllHeader, departStation, arriveStation, seatType, departDate, bookDate, status, amount)));
    }

    private Select getFilterByHeader(String header) {
        return new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format(filterByHeader, header))));
    }
    private WebElement getDateFilter() {
        return Constant.WEBDRIVER.findElement(dateFilter);
    }
    private WebElement getApplyFilterButton() {
        return Constant.WEBDRIVER.findElement(applyFilterButton);
    }
    private List<WebElement> getFilterHeaders() {
        return Constant.WEBDRIVER.findElements(filterHeaders);
    }


    public String getIdOfBtnCancel(String no){
        return getBtnCancelByValueNo(no).getAttribute("onclick");
    }

    public String getIdOfBtnDelete(String no){
        return getBtnDeleteByValueNo(no).getAttribute("onclick");
    }


    public void cancelTicketByValueNo(String no){
        WebElementManager.clickToElement(getBtnCancelByValueNo(no));
        WebElementManager.getAlert().accept();
    }
    public void deleteTicketByValueNo(String no){
        WebElementManager.clickToElement(getBtnDeleteByValueNo(no));
        WebElementManager.getAlert().accept();
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
    public int numberTicketRecord(){
        return getTicketRecordList().size() -1;
    }

    public List<String> getTableHeaderList() {
        List<String> headerList = new ArrayList<>();
        List<WebElement> headerElementList = getTicketHeaderList();
        for (WebElement header: headerElementList) {
            headerList.add(header.getText());
        }
        return headerList;
    }

    public boolean checkManageTableDisplays() {
        try {
            WebElement element = getTicketTable();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public String getNoteMessage() {
        return getNoteMsg().getText();
    }
    public int getNumberTicketByStatus(String status) {
        List<WebElement> valueElementList = getTicketsByStatus(status );
        return valueElementList.size();
    }

    public List<String> getTicketsValueByStatusAndHeader(String status, String header) {
        List<String> ticketValueList = new ArrayList<>();
        List<WebElement> valueElementList = getTicketByStatusAndHeader(status, header);
        for (WebElement value: valueElementList) {
            ticketValueList.add(value.getText());
        }
        return ticketValueList;
    }

    public int getNumberTicketsByStatusAndHeader(String status, String header) {
        int count =0;
        for (String value: getTicketsValueByStatusAndHeader(status, header)) {
            count += Integer.parseInt(value);
        }
        return count;
    }
    public List<String> getOperationButtonValueByStatus(String status) {
        List<String> ticketValueList = new ArrayList<>();
        List<WebElement> valueElementList = getOperationButtonByStatus(status);
        for (WebElement value: valueElementList) {
            ticketValueList.add(value.getAttribute("value"));
        }
        return ticketValueList;
    }

    public boolean checkTicketExist(String departStation, String arriveStation, String seatType, String departDate, String bookDate, String status, String amount) {
        try {
            List<WebElement> ticketList = getTicketByAllHeader(departStation,arriveStation, seatType, departDate, bookDate, status, amount);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkFilterExist(){
        try {
            WebElement element = getFilterTable();
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public void fillDataFilter(String depart, String arrive, String date, String status)  {
        if (depart != null) {
            getFilterByHeader("Depart Station").selectByVisibleText(depart);
            WebElementManager.waitElement(1000);
        }
        if (arrive != null) {
            getFilterByHeader("Arrive Station").selectByVisibleText(arrive);
        }
        if (date != null) {
            getDateFilter().sendKeys(date);
        }
        if (status != null) {
            getFilterByHeader("Status").selectByVisibleText(status);
        }
    }

    public void clickApplyFilterButton() {
        getApplyFilterButton().click();
    }

    public List<String> getUniqueValuesByHeader(String header) {
        List<String> ticketValueList = new ArrayList<>();
        List<WebElement> valueElementList = getAllTicketValuesByHeader(header);
        for (WebElement value: valueElementList) {
            ticketValueList.add(value.getText());
        }
        return new ArrayList<>(new HashSet<String>(ticketValueList));
    }

    public List<String> getUniqueValuesFilterByHeader(String header) {
        List<String> ticketValueList = new ArrayList<>();
        List<WebElement> valueElementList = getFilterByHeader(header).getOptions();
        for (WebElement value: valueElementList) {
            ticketValueList.add(value.getText());
        }
        return new ArrayList<>(new HashSet<String>(ticketValueList));
    }

    public int getTicketsByFilter(String depart, String arrive, String date, String status) {
        List<WebElement> webElements = getTicketByAllHeader(depart, arrive, "", date, "", status, "");
        return webElements.size();
    }

    public String getFirstTicketValueByHeader(String header) {
        List<String> ticketValueList = new ArrayList<>();
        List<WebElement> valueElementList = getAllTicketValuesByHeader(header);
        for (WebElement value: valueElementList) {
            ticketValueList.add(value.getText());
        }
        return ticketValueList.get(0);
    }

    public boolean checkOperationButtonDisplays(String status)
    {
        try {
            List<WebElement> webElementList = getOperationButtonByStatus(status);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public List<String> getFilterHeaderList() {
        List<WebElement> valueElementList = getFilterHeaders();
        List<String> ticketValueList = new ArrayList<>();
        for (WebElement value: valueElementList) {
            ticketValueList.add(value.getText());
        }
        return ticketValueList;
    }



}
