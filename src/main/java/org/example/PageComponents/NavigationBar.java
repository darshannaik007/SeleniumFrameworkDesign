package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar extends AbstractComponent {

    By flight = By.className("text-label");

    public NavigationBar(WebDriver driver, By ele){
        super(driver, ele);
    }

    public String getName(){
        return findElement(flight).getAttribute("class");

    }


}
