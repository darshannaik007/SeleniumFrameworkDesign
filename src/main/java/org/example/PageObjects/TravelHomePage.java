package org.example.PageObjects;

import org.example.AbstractComponents.FlightAvail;
import org.example.AbstractComponents.StrategyFactory;
import org.example.PageComponents.FooterNavigation;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelHomePage {
    WebDriver driver;
    By footerSection = By.id("traveller-home");
    By headerSection = By.className("search-buttons-heading");
    public By mainSection = By.id("flightSearchContainer");
    FlightAvail avail;

    public TravelHomePage(WebDriver driver1){
        driver = driver1;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }


    public NavigationBar getNavigationBar(){

        return new NavigationBar(driver, headerSection);
    }

    public FooterNavigation getFooterNavigation(){
        return new FooterNavigation(driver, footerSection);
    }

    public void setBookingStrategy(String strategyType){
        StrategyFactory sf = new StrategyFactory(driver);
        avail=sf.createStrategy(strategyType);
        //this.avail = avail;
    }

    public void checkAvailiblity(List<HashMap<String, String>> reservation1, Map<String, String> reservation2){
        avail.checkAvail(reservation1, reservation2);

    }

}
