package com.AutomateWithAnuj._19_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestSelenium29_StaticDropdowns {
    @Test
    public void Handle_the_StaticDropdowns(){
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement DD = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdown = new Select(DD);
//        dropdown.selectByIndex(1);
//        dropdown.selectByVisibleText("Option 1");
        dropdown.selectByValue("2");
    }
}
