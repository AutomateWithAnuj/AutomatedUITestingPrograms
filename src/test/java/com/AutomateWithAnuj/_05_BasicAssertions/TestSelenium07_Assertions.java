package com.AutomateWithAnuj._05_BasicAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium07_Assertions {
    @Test
    public void testMethod() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");

        //TestNG Assertions
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com");

        //AssertJ Assertion
        assertThat(driver.getCurrentUrl()).isNotNull().isNotBlank().isEqualTo("https://www.google.com");
    }
}
