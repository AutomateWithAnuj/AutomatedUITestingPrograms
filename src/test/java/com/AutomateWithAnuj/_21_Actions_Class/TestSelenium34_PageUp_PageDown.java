package com.AutomateWithAnuj._21_Actions_Class;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium34_PageUp_PageDown extends TestSelenium09_CommonToAll {
    @Test
    public void selectChandigarhOptionFromDropdown() throws InterruptedException {
        driver.get("https://blog.dectox.com/bad-websites-examples-2025/");
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(5000);
    }
}