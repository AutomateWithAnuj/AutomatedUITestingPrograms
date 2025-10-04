package com.AutomateWithAnuj._07_CommonToAllCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSelenium09_CommonToAll{
    public WebDriver openBrowser(String url){
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
    public void quitBrowser(WebDriver driver){
        driver.quit();
    }
}
