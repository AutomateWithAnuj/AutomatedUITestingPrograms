package com.AutomateWithAnuj._23_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium43_ElementClickInterceptedException {
    public static WebDriver driver;

    @BeforeTest
    public static void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Description("Trigger ElementClickInterceptedException when modal popup covers a button")
    @Test
    public void test_actions() throws InterruptedException {
        driver.navigate().to("https://www.w3schools.com/bootstrap5/tryit.asp?filename=trybs_modal_sm");

        // Wait for iframe to be present and switch
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));

        try {
            // Step 1: Open the modal popup
            WebElement openModal = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Open modal')]")));
            openModal.click();

            // Wait for modal to appear
            Thread.sleep(2000);

            // Step 2: Try clicking the same button again (intercepted by modal backdrop)
            openModal.click();

            System.out.println("Clicked background element successfully (this should NOT execute)");

            //First click (openModal.click()): Opens the modal popup.
            //The modal popup creates a backdrop that covers the background page, including the "Open modal" button itself.
            //Second click (openModal.click()): Selenium tries to click the same button again, but the modal backdrop is now in front of it.

        } catch (ElementClickInterceptedException e) {
            System.out.println("✅ ElementClickInterceptedException caught: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("⚠ Element not found, check if page structure changed: " + e.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
