package org.example.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private static List<WebDriver> driverpool = new ArrayList<WebDriver>();
    String browser;

    @BeforeMethod
    @Parameters("browser")
    public void beforeSetup(String browser){
        this.browser=browser;
    }


    public WebDriver getDriver(){
        return  getDriver1(browser);
    }

    private WebDriver getDriver1(String browser){
        WebDriver driver = DriverFactory.getInstance().getDriver(browser);
        driverpool.add(driver);
        return driver;
    }

    @AfterSuite
    public void tearDown(){
        for(WebDriver ele: driverpool){
            ele.close();
        }
    }
}
