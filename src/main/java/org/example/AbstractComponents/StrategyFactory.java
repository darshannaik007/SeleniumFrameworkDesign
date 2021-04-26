package org.example.AbstractComponents;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {
   WebDriver driver;

    public StrategyFactory(WebDriver webdriver) {
        this.driver = webdriver;
    }

    public FlightAvail createStrategy(String strategyType){
        if(strategyType.equals("multitrip")){
            return new MultiTrip(driver, new TravelHomePage(driver).mainSection);
        }
        else if(strategyType.equals("roundtrip")){
           return  new RoundTrip(driver, new TravelHomePage(driver).mainSection);
        } else {
            return null;
        }
    }
}
