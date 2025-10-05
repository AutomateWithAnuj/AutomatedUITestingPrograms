package com.AutomateWithAnuj._09_NoHttp;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium11_NoHttp {
    @Test
    public void testMethod() throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("bing.com"); // will fail HTTPs is important
        Thread.sleep(5000);
        driver.get("https://bing.com");
        driver.quit();
    }
}