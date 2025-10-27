package com.AutomateWithAnuj._25_MiniProject3;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium48_Ebay_Mac_mini_lowest_Prices extends TestSelenium09_CommonToAll {
    @Test
    public void Ebay_Mac_Mini_lowest_Prices(){
        driver.get("https://www.ebay.com/");

        WebElement search_box = driver.findElement(By.xpath("//input[@title='Search']"));
        search_box.sendKeys("Macmini");
        search_box.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@aria-label,'Sort')]")));

        WebElement sort_button = driver.findElement(By.xpath("//button[contains(@aria-label,'Sort')]"));
        sort_button.click();
        
        ////a[@href='https://www.ebay.com/sch/i.html?_nkw=macmini&_sacat=0&_sop=15']
        //button[contains(@aria-label,'Sort')]/following-sibling::*/ul/li[4]

        WebElement sort_lowest = driver.findElement(By.xpath("//button[contains(@aria-label,'Sort')]/following-sibling::*/ul/li[4]"));
        sort_lowest.click();

        List<WebElement> All_Prices = driver.findElements(By.xpath("//ul[contains(@class,'srp-results')]/li/div/div[2]/div[2]/div[1]/div[1]/span[1]"));

        for(WebElement price : All_Prices){
            System.out.println(price.getText());
        }
    }
}
