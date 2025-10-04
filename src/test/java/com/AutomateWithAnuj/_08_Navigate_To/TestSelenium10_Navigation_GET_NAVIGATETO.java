package com.AutomateWithAnuj._08_Navigate_To;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium10_Navigation_GET_NAVIGATETO {
    @Description("Open the URL")
    @Test
    public void test_Selenium01() throws Exception{
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com"); //used 95% times
        Thread.sleep(5000);

        //use navigation methods
        driver.navigate().to("https://bing.com");
        driver.navigate().back();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.quit();
    }
}
