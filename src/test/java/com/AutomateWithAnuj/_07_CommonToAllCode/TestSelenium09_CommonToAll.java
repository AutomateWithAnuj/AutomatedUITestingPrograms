package com.AutomateWithAnuj._07_CommonToAllCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void waitForVisibility(WebDriver driver, int timeout, String xpath){
        //like this we can create any number of common function for various conditions of explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
