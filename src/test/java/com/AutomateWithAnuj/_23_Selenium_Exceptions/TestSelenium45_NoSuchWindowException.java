package com.AutomateWithAnuj._23_Selenium_Exceptions;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium45_NoSuchWindowException {
    public static WebDriver driver;

    @BeforeTest
    public static void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void test_noSuchWindow() {
        driver.navigate().to("https://www.w3schools.com/html/html_forms.asp");

        try {
            // Attempting to switch to a window handle that does not exist
            driver.switchTo().window("non-existent-window-handle");
            System.out.println("Switched to window successfully (this should NOT happen)");
        } catch (NoSuchWindowException e) {
            System.out.println("✅ NoSuchWindowException caught: " + e.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}