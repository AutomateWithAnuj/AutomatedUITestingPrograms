package com.AutomateWithAnuj._23_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class TestSelenium40_StateElementReferenceExecption_ActualFix {
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
        driver.navigate().refresh(); //to fix this always refresh before finding any elements

        Thread.sleep(5000);

        try {
            WebElement inputBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
            //refinding the element after refresh is the most important to get rid of this exception
            Thread.sleep(5000);

            inputBox.sendKeys("Selenium Notes" + Keys.ENTER);
            //now this could give the StaleElementReferenceException
            //org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}