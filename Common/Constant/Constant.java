package Constant;

import Common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER ;
    public static final String RAILWAY_URL = "http://www.railwayb2.somee.com/";
    public static final String BOOKTICKET_DATA_PATH  =  Utilities.getPathProject()+"/DataObjects/BookTicketData.json";
    public static final String NEW_ACC_DATA_PATH  =  Utilities.getPathProject()+"/DataObjects/NewAccountData.json";
    public static final String EXISTED_ACC_DATA_PATH  =  Utilities.getPathProject()+"/DataObjects/ExistedAccountData.json";
    public static final String USERNAME = Utilities.getDataFromConfig("config.properties","username" );
    public static String PASSWORD = Utilities.getDataFromConfig( "config.properties", "password");


}
