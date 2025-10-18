package com.AutomateWithAnuj._17_Selenium_Waits;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium26_ExplicitWaits2 extends TestSelenium09_CommonToAll {
    //when we open the MakeMyTrip.com we get a popup to login using mobile number
    //we need to close this popup
    @Description("Verify Make My Trip")
    @Test
    public void testMakeMyTripAfter() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.navigate().to("https://www.makemytrip.com/");

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        //we can give 100 seconds also here because it will click in 3 to 5 seconds and save 97 to 95 seconds
        //also remember don't give the 1 second because then it could take more than 1 second
        //so always give the safe time like 3 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));*/

        waitForVisibility(driver,100,"//span[@data-cy='closeModal']");
        //like this we can create any number of common function for various conditions of explicit waits

        WebElement closebtn = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        closebtn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
