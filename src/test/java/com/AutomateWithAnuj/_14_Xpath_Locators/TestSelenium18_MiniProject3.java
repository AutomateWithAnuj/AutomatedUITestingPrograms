package com.AutomateWithAnuj._14_Xpath_Locators;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium18_MiniProject3 extends TestSelenium09_CommonToAll {
    @Description("Verify with the email and password and the appointment page is loaded")
    @Test
    public void test_katalon_login() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement btnMakeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        btnMakeAppointment.click();

        List<WebElement> username = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username.get(1).sendKeys("John Doe");

        List<WebElement> password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password.get(1).sendKeys("ThisIsNotAPassword");

        WebElement loginbtn = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginbtn.click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
    }
}
