package com.AutomateWithAnuj._02_SetupDriver;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02_SetupDriver {
    @Description("Open the app.vwo.com and verify the title!")
    @Test
    public void test_Selenium03(){
        //Selenium 3
        //you need to setup the Driver(browser)
        //System.getProperty("webdriver.edge.driver","/path/for/EdgeDriver");
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        //Selenium 4
        // Selenium Manager - utility - Which can download the driver automatically
        // start and stop itself.
        driver = new EdgeDriver();
        driver.get("https://google.com");
    }
}
