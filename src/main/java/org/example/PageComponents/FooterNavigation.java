package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbstractComponent {

    By flight = By.xpath("//*[@id=\"traveller-home\"]/div[1]/div/div[2]/a[1]/span[1]");
    By link = By.tagName("a");

    public FooterNavigation(WebDriver driver, By footerSection) {

        super(driver, footerSection);
    }

    public void SelectFlight(){

        findElement(flight).click();
    }

    public String getFlightName(){
        return findElement(flight).getAttribute("class");
    }

    public int getLinkCount(){
        return findElements(link).size();
    }
}
