package com.AutomateWithAnuj._17_Selenium_Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium24_ImplicitWaits {
    @Description("Verify Ebay Print iMac Prices")
    @Test
    public void testEbayPrint (){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.ebay.com/");

        //if you would like to wait for the 30sec for each element then we can use this
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //now you can do what you want to do
        driver.quit();
    }
}
