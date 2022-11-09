package Railway;

import Constant.Constant;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TimetableTest extends BaseTest{
    @Test
    public void TC01() {
        System.out.println("TC01- User can click on Book Ticket link ");
        HomePage homePage = new HomePage();
        homePage.openPage(Constant.RAILWAY_URL);
        homePage.clickTabTimetable();
        TimetablePage timetablePage = new TimetablePage();
        timetablePage.clickBookTicketLink("Huế", "Sài Gòn");

    }
}
