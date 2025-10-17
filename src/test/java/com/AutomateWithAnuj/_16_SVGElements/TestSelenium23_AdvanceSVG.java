package com.AutomateWithAnuj._16_SVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium23_AdvanceSVG {
    @Test(groups = "QA")
    @Description("Test Case Description")
    public void test_web_table_login() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        driver.manage().window().maximize();

        WebElement HandleCookie = driver.findElement(By.xpath("//button[contains(text(),'agree')]"));
        if (HandleCookie.isDisplayed()) {
            HandleCookie.click();
        }

        //to print all the states/union territory
        List<WebElement> SorUT = driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for (WebElement element : SorUT) {
            System.out.println(element.getAttribute("aria-label"));
        }

        //now we need to click on the madhya pradesh and it will get zoom out
        WebElement MPElement = driver.findElement(By.xpath("//*[name()='svg']/child::*[8]/child::*[1]/child::*/child::*[contains(@aria-label,'Madhya Pradesh')]"));
        //you can also use this xpath as well
        // "//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path' and contains(@aria-label,'Madhya Pradesh')]"
        MPElement.click();
        Thread.sleep(10000);

        driver.quit();
    }
}