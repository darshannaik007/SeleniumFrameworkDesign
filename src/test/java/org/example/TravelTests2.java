package org.example;

import org.example.PageObjects.TravelHomePage;
import org.example.Setup.BaseTest;
import org.example.Setup.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TravelTests2 extends BaseTest {
    WebDriver driver;
    //This Test suit gives us an idea of how to run the tests in parallel

    @Test
    public void Test1(){
        WebDriver driver = getDriver();
        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        String name = home.getFooterNavigation().getFlightName();
        int count = home.getFooterNavigation().getLinkCount();

        Assert.assertEquals("group-heading", name, "Flight name irrelevant");
        Assert.assertEquals(14,count,"Links number Mismatch");
    }

    @Test
    public void Test2(){
        WebDriver driver = DriverFactory.getInstance().getDriver("chrome");
        TravelHomePage home = new TravelHomePage(driver);
        home.goTo();
        String name = home.getNavigationBar().getName();

        Assert.assertEquals("text-label", name, "Flight name irrelevant");
    }
}
