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
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium15_Project_Locators_Selenium {
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

        //Step-1 Find the Email id and enter the email as admin@admin.com
        // <input                       //opening tag
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // placeholder="Enter email ID"
        // id="login-username"          //first attribute to check if its unique
        // data-qa="hocewoqisi"
        // >                            //Closing tag
        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");

        //Step-2 Find the Password input box and enter password as admin
        //<input
        // type="password"
        // class="text-input W(100%)"
        // placeholder="Enter password"
        // name="password"
        // id="login-password"
        // data-qa="jobodapuxe"
        // >
        WebElement pass_input_box = driver.findElement(By.name("password"));
        pass_input_box.sendKeys("admin");

        // Step-3 Find and Click on the submit button
        // <button
        // type="submit"
        // id="js-login-btn"
        // class="btn btn--primary btn--inverted W(100%) H(48px) Fz(16px)" //this is the dynamic class as the width will change
        // onclick="login.login(event)"
        // data-qa="sibequkica">
        // <span class="icon loader hidden" data-qa="zuyezasugu"></span>
        // <span data-qa="ezazsuguuy">Sign in</span> </button>
        WebElement Submit_btn = driver.findElement(By.id("js-login-btn"));
        Submit_btn.click();

        //Step-4 Wait for sometime
        Thread.sleep(5000);

        //Step-5 Verify that the error message is shown.
        //<div
        // class="notification-box-description"
        // id="js-notification-box-msg"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match
        // </div>
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_message.getText());

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
