package com.AutomateWithAnuj._17_Selenium_Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class TestSelenium27_FluentWaits {
    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    @Owner("Anuj Rajput")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_vwo_invalid_login() throws InterruptedException {
        // Locators - Find the Web elements

        //start the fresh copy of browser maximised
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        //implicit wait we can use on the top like here
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open the URL https://app.vwo.com/#/login
        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        //Step-1 Find the Email id and enter the email as admin@admin.com
        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");

        //Step-2 Find the Password input box and enter password as admin
        WebElement pass_input_box = driver.findElement(By.name("password"));
        pass_input_box.sendKeys("admin");

        // Step-3 Find and Click on the submit button
        WebElement Submit_btn = driver.findElement(By.id("js-login-btn"));
        Submit_btn.click();

        //Step-4 Wait for some time and //Step-5 Verify that the error message is shown.
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        //here we are ignoring the NoSuchElementException because it can throw that after 2 sec

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.className("notification-box-description"));
                String text = el.getText().trim();
                if (!text.isEmpty()) {
                    return el;
                } else {
                    return null; // keep waiting
                }
            }
        });

        System.out.println(error_message.getText());

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }
}