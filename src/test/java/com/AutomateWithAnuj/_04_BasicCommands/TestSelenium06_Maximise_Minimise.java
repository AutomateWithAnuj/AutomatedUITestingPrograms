package com.AutomateWithAnuj._04_BasicCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium06_Maximise_Minimise {
    @Test
    public void testMethod() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");

        driver.manage().window().maximize(); //to run the test in maximise
        driver.manage().window().minimize(); //to run the test in minimise

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit(); //it will close the browser and the session also
    }

}
