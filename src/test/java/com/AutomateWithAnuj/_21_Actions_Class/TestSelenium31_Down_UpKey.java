package com.AutomateWithAnuj._21_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium31_Down_UpKey {
    @Test
    public void Press_Down_Up_Key() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement Input_FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT)
                .sendKeys(Input_FirstName,"anuj singh")
                .keyUp(Keys.SHIFT)
                .build().perform();

        Thread.sleep(3000);
    }
}
