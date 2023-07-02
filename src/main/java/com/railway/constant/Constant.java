package com.railway.constant;

import com.railway.common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER ;
    public static final String RAILWAY_URL = "http://www.railwayb2.somee.com/";
    public static final String BOOKTICKET_DATA_PATH  =  Utilities.getPathProject()+"/src/main/java/com/railway/dataObjects/BookTicketData.json";
    public static final String NEW_ACC_DATA_PATH  =  Utilities.getPathProject()+"/src/main/java/com/railway/dataObjects/NewAccountData.json";
    public static final String EXISTED_ACC_DATA_PATH  =  Utilities.getPathProject()+"/src/main/java/com/railway/dataObjects/ExistedAccountData.json";
    public static int ticketQuantity = 10;
    public static final String EXTEND_REPORT_PATH  =  Utilities.getPathProject()+"src/test/resources/reports";



}
