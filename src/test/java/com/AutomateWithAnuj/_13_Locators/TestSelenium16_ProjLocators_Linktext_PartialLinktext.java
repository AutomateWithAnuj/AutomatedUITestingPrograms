package com.AutomateWithAnuj._13_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium16_ProjLocators_Linktext_PartialLinktext {
    @Description("TC#1 - Verify that with invalid login, error message is displayed!")
    @Owner("Anuj Rajput")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_vwo_invalid_login() throws InterruptedException {
        // Locators - Find the Web elements

        //start the fresh copy of browser maximised
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        // Open the URL https://app.vwo.com/#/login
        driver.get("https://app.vwo.com");

        // let us click on the start a free trial button in this page
        // <a
        // href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link Td(n)"
        // data-qa="bericafeqo">Start a free trial</a>

        WebElement startFreeTrialFullLinkText = driver.findElement(By.linkText("Start a free trial"));
        startFreeTrialFullLinkText.click();

        WebElement startFreeTrialPartialLinkText = driver.findElement(By.linkText("trial"));
        // Start a free trial
        // Start a free
        // Start a
        // Start , Trail, free, a, Star...
        startFreeTrialPartialLinkText.click();
        Thread.sleep(5000);

        driver.quit();
    }
}
