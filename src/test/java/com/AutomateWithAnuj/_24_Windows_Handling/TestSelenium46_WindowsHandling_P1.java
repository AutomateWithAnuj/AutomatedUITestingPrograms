package com.AutomateWithAnuj._24_Windows_Handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class TestSelenium46_WindowsHandling_P1 {
    public WebDriver driver;
    @Test
    public void test1() throws InterruptedException {
        driver = new EdgeDriver();
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String parent = driver.getWindowHandle();
        System.out.println(parent); //C8803B4945189F0F0975C47E9AA14D0A

        WebElement clickOption = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickOption.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        for(String windowHandle : windowHandles){
            driver.switchTo().window(windowHandle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed!");
            }
            driver.switchTo().window(parent);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
