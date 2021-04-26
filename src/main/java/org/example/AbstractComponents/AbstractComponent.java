package org.example.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {
    private final WebElement SectionElement;
    WebDriver driver;

    public AbstractComponent(WebDriver webdriver, By Section) {
        this.SectionElement = webdriver.findElement(Section);
        this.driver = webdriver;
    }

    public WebElement findElement(By ele){

        return SectionElement.findElement(ele);
    }

    public List<WebElement> findElements(By ele){
        return SectionElement.findElements(ele);
    }

    public void waitForElementToDisappear(By ele){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOf(findElement(ele)));
    }
}
