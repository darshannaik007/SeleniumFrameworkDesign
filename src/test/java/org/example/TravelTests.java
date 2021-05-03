package org.example;

import org.example.PageObjects.TravelHomePage;
import org.example.Setup.Initilization;
import org.example.Setup.ListenerTestNG;
import org.example.TestData.Cities;
import org.example.TestData.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(ListenerTestNG.class)
public class TravelTests extends Initilization {

    //This test suit gives us an idea of how to run the tests in multiple browser and Captures the Screenshot on test failure
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void BeforeTest(String browser, ITestContext context){
        driver = initilizeDriver(browser, context);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void AfterTest(){
        driver.close();
    }

    @Test
    public void Test1(){

        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        String name = home.getFooterNavigation().getFlightName();
        int count = home.getFooterNavigation().getLinkCount();

        Assert.assertEquals("group-heading", name, "Flight name irrelevant");
        Assert.assertEquals(14,count,"Links number Mismatch");
    }

    @Test
    public void Test2(){
        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        String name = home.getNavigationBar().getName();

        Assert.assertEquals("text-label", name, "Flight name irrelevant");
    }

    @Test(dataProvider = "getData", enabled = false)
    public void Test3(List<HashMap<String, String>> cities)  {
        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        home.setBookingStrategy("roundtrip");
        home.checkAvailiblity(cities, null);

    }

    @Test
    public void Test4(){
        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        home.setBookingStrategy("multitrip");
        Map<String, String> reservation = new HashMap<String, String>();
        reservation.put("origin1", Cities.source1);
        reservation.put("destination1", Cities.destination1);
        reservation.put("origin2", Cities.source2);
        reservation.put("destination2", Cities.destination2);
        home.checkAvailiblity(null, reservation);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/src/main/java/org/example/TestData/Cities.json";
        path=path.replace("/","\\");
        System.out.println(path);
        List<HashMap<String, String>> ls = new DataReader().getJsonData(path);
        return new Object[][]{
                {ls.get(0), ls.get(1)}
        };
    }

}
