package com.AutomateWithAnuj._27_Relative_locators;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestSelenium52_RL_P3_RealAQIExample extends TestSelenium09_CommonToAll {
    @Test
    public void TestSelenium52_RL_P3_RealAQIExample() {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        WebElement search_bar = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search_bar.sendKeys("India");
        search_bar.sendKeys(Keys.ENTER);

        String initalVal = "//div[contains(@class,'cities-list')]/div[2]/div[2]/a[";
        String finalVal = "]/div/p";
        int CitisOnFirstPage = driver.findElements(By.xpath("//div[contains(@class,'cities-list')]/div[2]/div[2]/a")).size();
        String Citi_Xpath;
        WebElement Citi_Element;
        for (int i = 1; i <= CitisOnFirstPage; i++) {
            Citi_Xpath = initalVal + i + finalVal;
            Citi_Element = driver.findElement(By.xpath(Citi_Xpath));
            System.out.print(driver.findElement(with(By.tagName("p")).toLeftOf(Citi_Element)).getText()+"  ");
            System.out.print(Citi_Element.getText()+"  ");
            System.out.println(driver.findElement(with(By.tagName("span")).toRightOf(Citi_Element)).getText());
        }
    }
}
