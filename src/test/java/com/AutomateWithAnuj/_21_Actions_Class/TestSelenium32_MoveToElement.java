package com.AutomateWithAnuj._21_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium32_MoveToElement {
    @Test
    public void Test_moveToElement_click() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://spicejet.com");
        driver.manage().window().maximize();

        WebElement Input_From_Location = driver.findElement(By.xpath("//*[@data-testid='to-testID-origin']/*[name()='div']/*[name()='div'][2]/input"));
        Actions action = new Actions(driver);
        action.moveToElement(Input_From_Location).click().sendKeys("GWL").build().perform();
        //if you will not use the build.perform then
        //it will work only for some steps then it will not work like till move to element only
    }
}