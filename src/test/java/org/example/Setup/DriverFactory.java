package org.example.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    //Singleton Design Pattern
    private static final DriverFactory instance = new DriverFactory();

    private DriverFactory(){
    }

    public static DriverFactory getInstance(){
        return instance;
    }

    //Factory Design Pattern
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>(){

        protected WebDriver initialValue(){
            return new ChromeDriver();
        }
    };

    public WebDriver getDriver(){
        return threadLocal.get();
    }
}
