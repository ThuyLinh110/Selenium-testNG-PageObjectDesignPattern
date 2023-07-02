package com.railway.test;
import com.railway.common.DriverManager;
import com.railway.common.Log;
import com.railway.common.Utilities;
import com.railway.constant.Constant;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browserType) {
        Log.info("Pre-condition");
        DriverManager.openBrowser(browserType);
        DriverManager.maximizePage();
        DriverManager.openPageByUrl(Constant.RAILWAY_URL);

    }
    @AfterMethod
    public void afterMethod() {
        Log.info("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
