package com.AutomateWithAnuj._16_SVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium22_BasicSVG {
    @Test(groups = "QA")
    @Description("Test Case Description")
    public void test_web_table_login() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("macmini");
        //driver.findElement(By.xpath("//*[name()='svg']")).click(); //use this if we have 1 svg element in the HTML
        List<WebElement> elements = driver.findElements(By.xpath("//*[name()='svg']"));
        elements.get(0).click();
        driver.quit();
    }
}
