package org.example;


import org.example.PageObjects.TravelHomePage;
import org.example.TestData.Cities;
import org.example.TestData.DataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNGException;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TravelTests extends Initilization{
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void BeforeTest(String browser){
        driver = initilizeDriver(browser);
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

    @Test(dataProvider = "getData")
    public void Test3(List<HashMap<String, String>> cities)  {
        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        home.setBookingStrategy("roundtrip");
        /*Map<String, String> reservation = new HashMap<String, String>();
        reservation.put("origin1", Cities.source1);
        reservation.put("destination1", Cities.destination1);
        */
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
