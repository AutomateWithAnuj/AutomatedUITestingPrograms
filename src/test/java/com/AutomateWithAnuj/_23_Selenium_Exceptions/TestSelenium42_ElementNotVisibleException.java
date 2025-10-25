package com.AutomateWithAnuj._23_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium42_ElementNotVisibleException {
    public static WebDriver driver;

    @BeforeTest
    public static void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Handle ElementNotInteractableException when clicking hidden element")
    @Test
    public static void test_actions() throws InterruptedException {
        // Simple local HTML page hosted by W3Schools that hides element using display:none
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        try {
            // switching to iframe because W3Schools uses one for TryIt examples
            driver.switchTo().frame("iframeResult");

            // locating the disabled input box (non-interactable)
            WebElement hiddenElement = driver.findElement(By.xpath("//input[@disabled]"));

            // trying to send keys to disabled element to raise ElementNotInteractableException
            hiddenElement.sendKeys("Testing hidden input");

            System.out.println("Sent text successfully (this line will not execute)");

        } catch (ElementNotInteractableException e) {
            System.out.println("Element is not interactable (disabled/hidden): " + e.getMessage());
        }

        driver.quit();
    }
}
