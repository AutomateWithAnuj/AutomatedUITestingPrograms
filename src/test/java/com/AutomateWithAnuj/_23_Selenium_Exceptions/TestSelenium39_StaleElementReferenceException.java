package com.AutomateWithAnuj._23_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class TestSelenium39_StaleElementReferenceException {
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

        WebElement inputBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        driver.navigate().refresh(); //HTML page (DOM) is now refreshed.
        //driver will think element will may or may not be available now
        //we have found the element before refresh

        //after refresh, you can be moved to other HTML page (DOM)

        Thread.sleep(5000);

        try {
            inputBox.sendKeys("Selenium Notes"+Keys.ENTER);
            //now this could give the StaleElementReferenceException
            //org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
