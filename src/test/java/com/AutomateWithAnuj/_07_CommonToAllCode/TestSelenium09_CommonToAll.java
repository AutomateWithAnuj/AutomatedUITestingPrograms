package com.AutomateWithAnuj._07_CommonToAllCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestSelenium09_CommonToAll{

    public EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

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
    public void waitForTextToBePresent(WebDriver driver, int timeInSeconds, By locator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator), expectedText));
    }

    @AfterTest
    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
