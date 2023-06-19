package com.railway.pageObjects;
import com.railway.common.WebElementManager;
import com.railway.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MyTicketPage extends BasePage{

    private String cancelByNoBtn = "//tr[td[count(//div[@class = 'DivCenter']//th[.='No']/preceding-sibling::th)+1][.='%s']]//input[@value='Cancel']";
    private String cancelByIdBtn = "//input[@onclick ='%s']";
    private String ticketValuesByHeader = "//td[count(//div[@class = 'DivCenter']//th[.='%s']/preceding-sibling::th)+1]";
    private By ticketRecordList = By.xpath("//table[@class = 'MyTable']//tr");
    private By ticketHeaderList = By.xpath("//tr[@class='TableSmallHeader']/th");
    private By ticketTable = By.xpath("//table[@class = 'MyTable']");
    private By noteMsg = By.xpath("//div[@class='message']//li");
    private String ticketByStatus = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][.='%s']]";
    private String ticketAmountByStatusAndHeader = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][.='%s']]//td[count(//div[@class = 'DivCenter']//th[.='%s']/preceding-sibling::th)+1]";

    private String operationButtonByStatus = "//tr[td[count(//div[@class = 'DivCenter']//th[.='Status']/preceding-sibling::th)+1][.='%s']]//td[count(//div[@class = 'DivCenter']//th[.='Operation']/preceding-sibling::th)+1]//input";

    private WebElement getBtnCancelByValueNo(String no){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(cancelByNoBtn,no)));
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


    public String getIdOfBtnCancel(String no){
        return getBtnCancelByValueNo(no).getAttribute("onclick");
    }


    public void cancelTicketByValueNo(String no){
        WebElementManager.clickToElement(getBtnCancelByValueNo(no));
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
        int count = 0;
        List<WebElement> valueElementList = getTicketsByStatus(status );
        for (WebElement value: valueElementList) {
            count += 1;
        }
        return count;
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
    

}
