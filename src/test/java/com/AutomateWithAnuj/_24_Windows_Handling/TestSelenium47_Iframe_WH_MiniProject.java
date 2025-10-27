package com.AutomateWithAnuj._24_Windows_Handling;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestSelenium47_Iframe_WH_MiniProject extends TestSelenium09_CommonToAll {
    @Test
    public void Test_Wingify_Map(){
        driver.get("https://wingify.com/");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent -> "+parentWindowHandle);

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//*[@class='wingify-logo']"))).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//div[@id='mapDiv']/div/div[3]/iframe")));


        driver.findElement(By.xpath("//a[contains(text(),'View larger map')]")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if(!handle.equals(parentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        WebElement input_Address =  driver.findElement(By.xpath("//input[contains(@id,'searchboxinput')]"));
        input_Address.sendKeys("Gwalior");
        input_Address.sendKeys(Keys.ENTER);
    }
}
