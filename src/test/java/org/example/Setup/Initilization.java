package org.example.Setup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class Initilization {
    WebDriver driver;

    public WebDriver initilizeDriver(String browser, ITestContext context){
        try{
            if(browser.equals("chrome")){
                System.setProperty("webdriver.chrome.driver","C:\\Software\\Selenium\\chromedriver.exe");
                driver = new ChromeDriver();
                context.setAttribute("WebDriver", driver);
                return driver;
            } else if(browser.equals("firefox")){
                return driver = new FirefoxDriver();
            } else {
                throw new WebDriverException("Browser not Supported");
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

}
