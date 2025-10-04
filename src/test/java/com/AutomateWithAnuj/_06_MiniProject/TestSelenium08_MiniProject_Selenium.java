package com.AutomateWithAnuj._06_MiniProject;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium08_MiniProject_Selenium {
    @Description("Open the URL")
    @Test
    public void test_Selenium01() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        if (driver.getPageSource().contains("CURA Healthcare Service")) {
            System.out.println("TestCase Passed");
            Assert.assertTrue(true);
        } else {
//            Assert.fail("CURA Healthcare Service is not visible");
            throw new Exception("TestCase Failed");
        }
    }
}