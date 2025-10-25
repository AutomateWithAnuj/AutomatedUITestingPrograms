package com.AutomateWithAnuj._23_Selenium_Exceptions;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class TestSelenium41_TimeOutExcepton{
    public static WebDriver driver;

    @BeforeTest
    public static void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Verify URL")
    @Test
    public static void test_actions() throws InterruptedException, AWTException {
        driver.navigate().to("https://google.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ABC']")));
            //this will give the TimeoutException
            //org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //input[@id='ABC'] (tried for 10 second(s) with 500 milliseconds interval)

            WebElement inputBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
            Thread.sleep(5000);

            inputBox.sendKeys("Selenium Notes" + Keys.ENTER);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}