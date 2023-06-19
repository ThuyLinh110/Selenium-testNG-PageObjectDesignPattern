package com.railway.common;


import com.railway.constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverManager {
    public static void openBrowser(String browserType){
        switch (browserType) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Utilities.getPathProject() + "\\Executables\\geckodriver.exe");
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Utilities.getPathProject() + "\\src\\main\\java\\com\\railway\\excutables\\chromedriver.exe");
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            default:
                break;
        }

    }

    public static void maximizePage(){
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void openPageByUrl(String baseUrl)
    {
        Constant.WEBDRIVER.navigate().to(baseUrl);
    }

}
