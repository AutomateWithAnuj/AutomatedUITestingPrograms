package com.AutomateWithAnuj._26_JavaScriptExecutor;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium49_NavigateToURL extends TestSelenium09_CommonToAll {
    @Test
    public void TestSelenium49_NavigateToURL(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://selectorshub.com/xpath-practice-page/'");
        
        js.executeScript("window.scrollBy(0,500)");

    }
}
