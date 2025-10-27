package com.AutomateWithAnuj._27_Relative_locators;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestSelenium50_RelativeLocators_P1 extends TestSelenium09_CommonToAll {
    @Test
    public void test_js(){
        driver.get("https://awesomeqa.com/practice.html");

        WebElement span_element = driver.findElement(By.xpath("//span[contains(text(),'Years of Experience')]"));
        driver.findElement(with(By.id("exp-1")).toRightOf(span_element)).click();
        //always try to understand this from back
            //in the right of span_element
            //their is an element with id exp-1


    }
}
