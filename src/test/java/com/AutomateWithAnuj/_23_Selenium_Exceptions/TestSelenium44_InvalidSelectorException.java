package com.AutomateWithAnuj._23_Selenium_Exceptions;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium44_InvalidSelectorException {
    public static WebDriver driver;

    @BeforeTest
    public static void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void test_invalidSelector() {
        driver.navigate().to("https://www.w3schools.com/html/html_forms.asp");

        try {
            // Using an invalid XPath deliberately
            driver.findElement(By.xpath("//button[@type='button'][100]"));
            System.out.println("Element found successfully (this should NOT happen)");
        } catch (InvalidSelectorException e) {
            System.out.println("✅ InvalidSelectorException caught: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("⚠ Element not found: " + e.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}