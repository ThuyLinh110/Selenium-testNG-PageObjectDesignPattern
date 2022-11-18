package Constant;

import Common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER ;
    public static final String Path_InvalidPassword = Utilities.getPathProject()+"/DataObjects/InvalidPassword.xlsx";
    public static final String Path_NotExistedEmail = Utilities.getPathProject()+"/DataObjects/NotExistedEmail.xlsx";

    public static final String RAILWAY_URL = "http://www.railwayb2.somee.com/";

    public static final String USERNAME = Utilities.getDataFromConfig("config.properties","username" );
    public static String PASSWORD = Utilities.getDataFromConfig( "config.properties", "password");

    public static final String INVALID_PASSWORD = "123450";

}
