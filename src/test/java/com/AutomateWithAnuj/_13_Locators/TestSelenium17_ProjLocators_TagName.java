package com.AutomateWithAnuj._13_Locators;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium17_ProjLocators_TagName {
    @Owner("Anuj")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://bugz.atlassian.net/browse/BUG-17")
    @Description("Verify the error message comes with invalid email on signup page")
    @Test
    public void vwo_free_trial_error_verify() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        WebElement startFreeTrialPartialLinkText = driver.findElement(By.partialLinkText("trial"));
        startFreeTrialPartialLinkText.click();

        System.out.println("URL: "+driver.getCurrentUrl());

        //to validate id the free trial is really clicked or not
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc");

        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        //now let us check the invalid message for invalid email
        //classes are - C(--color-red) Fz(--font-size-12) Trsp(--Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason
        //space in between defines the multiple classes
        //each of these are the different classes but the one which is not dynamic you can take
        //so the beauty of the selenium locators is to get the static part itself and find the element
        WebElement error_msg = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_msg.getText(), "The email address you entered is incorrect.");

        driver.quit();
    }
}