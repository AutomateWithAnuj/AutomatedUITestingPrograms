package com.AutomateWithAnuj._27_Relative_locators;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class TestSelenium51_RelativeLocators_P2 extends TestSelenium09_CommonToAll {
    @Test
    public void TestSelenium51_RelativeLocators_P2(){
        //verifying the invalid email message using the relative locators
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='result']"));
        driver.switchTo().frame(iframe);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//form[@id='form']/button")).click();

        WebElement userid = driver.findElement(By.xpath("//input[@id='username']"));
        String error_userid = driver.findElement(with(By.tagName("small")).below(userid)).getText();
        Assert.assertEquals(error_userid,"Username must be at least 3 characters");
    }
}
