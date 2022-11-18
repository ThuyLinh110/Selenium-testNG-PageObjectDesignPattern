package Railway;
import Common.DriverManager;
import Common.Log;
import Common.Utilities;
import Constant.Constant;
import org.apache.log4j.xml.DOMConfigurator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("browser")

    @BeforeMethod
    public void beforeMethod(String browserType) {
        Log.info("Pre-condition");
        DriverManager.openBrowser(browserType);
        DriverManager.maximizePage();
        DriverManager.openPageByUrl(Constant.RAILWAY_URL);
        DOMConfigurator.configure(Utilities.getPathProject()+ "\\log4j.xml");

    }
    @AfterMethod
    public void afterMethod() {
        Log.info("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
