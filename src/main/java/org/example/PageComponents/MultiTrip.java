package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.FlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements FlightAvail {
    WebDriver driver;
    private By multiRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By alertAccept = By.id("MultiCityModelAlert");
    private By from1 = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By to1 = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");

    public MultiTrip(WebDriver driver1, By ele){
        super(driver1, ele);
        this.driver=driver1;
    }

    @Override
    public void checkAvail(List<HashMap<String, String>> reservation1, Map<String, String> reservation2){
        makeStateReady(s -> selectOriginCity(reservation2.get("origin1")));
        selectOriginCity(reservation2.get("origin1"));
        selectDestinationCity(reservation2.get("destination1"));
        selectOriginCity2(reservation2.get("origin2"));
    }

    public void selectOriginCity(String origin){
        findElement(from1).click();
        findElement(By.xpath("(//a[@value='"+origin+"'])[1]")).click();
    }

    public void selectOriginCity2(String origin){
        findElement(from2).click();
        findElement(By.xpath("(//a[@value='"+origin+"'])[3]")).click();
    }
    public void selectDestinationCity(String destination){
        findElement(to1).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        findElement(multiRadio).click();
        findElement(alertAccept).click();
        waitForElementToDisappear(alertAccept);
        consumer.accept(this);
    }
}
