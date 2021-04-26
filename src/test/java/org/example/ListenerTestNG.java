package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ListenerTestNG implements ITestListener {
    WebDriver driver=null;

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        driver = (WebDriver)context.getAttribute("WebDriver");
        getScreenShot(methodName, driver);

    }

    public void getScreenShot(String methodName, WebDriver driver){
        TakesScreenshot sc = (TakesScreenshot)driver;
        File src = sc.getScreenshotAs(OutputType.FILE);

        try{
            String path = System.getProperty("user.dir")+"/src/test/java/ScreenShots/";
            path=path.replace("/","\\");
            System.out.println("************"+path+methodName+".png");
            File dest = new File(path+methodName+".png");
            FileUtils.copyFile(src, dest);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
