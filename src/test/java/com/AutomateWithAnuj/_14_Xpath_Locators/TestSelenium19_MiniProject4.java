package com.AutomateWithAnuj._14_Xpath_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium19_MiniProject4 {
    @Test
    public void OrangeHRMLogin() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement username_txt = driver.findElement(By.xpath("//*[contains(@name,'username')]"));
        username_txt.sendKeys("admin");

        Thread.sleep(3000);

        WebElement password_txt = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        password_txt.sendKeys("password");

        Thread.sleep(3000);

        WebElement login_btn = driver.findElement(By.xpath("//button[contains(normalize-space(),'Login')]"));
        login_btn.click();

        Thread.sleep(3000);

        driver.quit();
    }
}
