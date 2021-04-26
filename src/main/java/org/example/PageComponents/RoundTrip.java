package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.FlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundTrip extends AbstractComponent implements FlightAvail  {

    private By roundRadio = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By student = By.id("StudentDiv");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By ele){
        super(driver, ele);
    }


    @Override
    public void checkAvail(List<HashMap<String, String>> reservation, Map<String, String> reservation2){
        findElement(roundRadio).click();
        selectSource((reservation.get(0)).get("origin1"));
        selectDestination((reservation.get(0)).get("destination1"));
        //Search();
    }

    public void selectSource(String origin){
        findElement(from).click();
        findElement(By.xpath("(//a[@value='"+origin+"'])[1]")).click();
    }

    public void selectDestination(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();

    }

    /*public void Search(){
        findElement(search).click();
    } */
}
