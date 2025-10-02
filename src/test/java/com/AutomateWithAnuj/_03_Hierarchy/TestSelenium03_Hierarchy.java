package com.AutomateWithAnuj._03_Hierarchy;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium03_Hierarchy {
    @Description("Open the app.vwo.com and verify the title!")
    @Test
    public void test_Selenium02(){
        EdgeDriver driver = new EdgeDriver();
        //why here EdgeDriver is a class because we are able to create its object
        //only classes can have their objects in java
        //new EdgeDriver() will create a post request to create a session with a 16 digit unique ID

        //Navigate the URL -> HTTP GET the URL
        driver.get("https://app.vwo.com");

        //Assert the URL - validation - TestNG Assertions
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
    }
}
