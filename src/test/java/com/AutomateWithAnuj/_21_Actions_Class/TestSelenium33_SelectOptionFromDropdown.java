package com.AutomateWithAnuj._21_Actions_Class;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.beans.Visibility;
import java.time.Duration;
import java.util.List;

public class TestSelenium33_SelectOptionFromDropdown extends TestSelenium09_CommonToAll {
    @Test
    public void selectChandigarhOptionFromDropdown() throws InterruptedException {

        driver.get("https://www.makemytrip.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-cy='closeModal']")));

        //wait for the popup to come and the click the x icon
        WebElement close_popup = driver.findElement(By.xpath("//*[@data-cy='closeModal']"));
        close_popup.click();

        //closing travel card
        WebElement close_travel_Card = driver.findElement(By.xpath("//span[@data-testid='travel-card-close']"));
        close_travel_Card.click();

        Thread.sleep(5);

        WebElement From_city = driver.findElement(By.xpath("//input[@id='fromCity']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(From_city).click().build().perform();

        Thread.sleep(5);

        // If normal sendKeys fails → try Actions sendKeys → else use JavaScriptExecutor

        WebElement Input_From_city = driver.findElement(By.xpath("//*[@placeholder='From']"));
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='IXC';", Input_From_city);

        actions.click().build().perform();

        Thread.sleep(5);

        //click on the Chandigarh option from dropdown
        List<WebElement> AllDD_options = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
        for (WebElement option : AllDD_options) {
            if (option.getText().contains("Chandigarh")) {
                option.click();
                break;
            }
        }

        Thread.sleep(10);

        tearDown();
    }
}