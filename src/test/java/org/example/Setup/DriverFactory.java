package org.example.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    //Singleton Design Pattern
    private static final DriverFactory instance = new DriverFactory();

    private DriverFactory(){
    }

    public static DriverFactory getInstance(){
        return instance;
    }

    //Factory Design Pattern
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(String browser){
        if(threadLocal.get()==null){
            switch (browser){
                case "chrome":  System.setProperty("webdriver.chrome.driver","C:\\Software\\Selenium\\chromedriver.exe");
                                System.out.println("******************************: Done");
                                threadLocal.set(new ChromeDriver());
                                break;
                case "firefox":
                                threadLocal.set(new FirefoxDriver());
                                break;
                case "ie":
                            threadLocal.set(new InternetExplorerDriver());
                            break;

                default: break;

            }
        }
        return threadLocal.get();
    }
}
