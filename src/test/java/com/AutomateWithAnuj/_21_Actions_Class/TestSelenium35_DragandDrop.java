package com.AutomateWithAnuj._21_Actions_Class;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium35_DragandDrop extends TestSelenium09_CommonToAll {
    @Test
    public void DragandDropTest() throws InterruptedException {
        openBrowser();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(5000);
        WebElement A = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement B = driver.findElement(By.xpath("//div[@id='column-b']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(A,B).build().perform();
        Thread.sleep(5000);
    }
}
