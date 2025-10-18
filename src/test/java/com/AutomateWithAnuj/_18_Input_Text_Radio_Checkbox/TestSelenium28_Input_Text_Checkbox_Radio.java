package com.AutomateWithAnuj._18_Input_Text_Radio_Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium28_Input_Text_Checkbox_Radio {
    //textbox, checkbox and radio button are types of HTML <input> elements.
    @Test
    public void TestSelenium28_Input_Checkbox_Radio_Checkbox() throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        //Text Box
        driver.findElement(By.xpath("//input[@type='text' and @name='firstname']")).sendKeys("Anuj");

        //Check Box
        driver.findElement(By.xpath("//input[@type='checkbox' and @id='profession-0']")).click();

        //Radio Buttons
        driver.findElement(By.xpath("//input[@type='radio' and @id='sex-0']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
