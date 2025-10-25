package com.AutomateWithAnuj._23_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium38_NoSuchElementException {
    public static WebDriver driver;
    @BeforeTest
    public static void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Verify URL")
    @Test
    public static void test_actions() throws InterruptedException {
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        try {
            WebElement e = driver.findElement(By.xpath("//*[@id='anuj']"));
        } catch (NoSuchElementException ex) { //we can also use WebDriverException also here on place of NoSuchElementException
            ex.printStackTrace();
        }
        //the above line will throw the noSuchElementException
        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//*[@id='anuj']"}


        //after this exception nothing will work until you will surround it by try catch
        driver.get("https://google.com");
        //put there is no point to move it to the next command if you are not able to find that element
    }
}
