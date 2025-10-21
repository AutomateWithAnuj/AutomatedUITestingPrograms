package com.AutomateWithAnuj._20_Shadow_DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium30_Shadow_DOM {
    @Test
    public void test_shadow_dom() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

                /*
        WebElement pizza = driver.findElement(By.xpath("//input[[@id='pizza']"));
        pizza.sendKeys("farmhouse");
        //InvalidSelectorException occurs when the locator (like XPath or CSS Selector) you’ve written is not valid or cannot be used for that element type.
        */

        //these JavaScript Executor is primarily used to execute the javascript code

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert(1)");
//        js.executeScript("alert('Hello World!')");

//        System.out.println(js.executeScript("document.title"));

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);", div_to_scroll);
        //so the div_to_scroll is going into the arguments[0] and then JS executor is scrolling until that is visible

        Thread.sleep(3000);

        //now check this element from the console output using command document.querySelector("div#userName")
        //document.querySelector("div#userName"); //it is written using CSS Selector language

        WebElement pizza = (WebElement) js.executeScript(
                "return document.querySelector('div#userName')" +
                        ".shadowRoot.querySelector('div#app2')" +
                        ".shadowRoot.querySelector('input#pizza');"
        );
        pizza.sendKeys("farmhouse");

        //to print the url and title of the page
        String url = js.executeScript("return document.URL;").toString();
        System.out.println(url);
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);

        Thread.sleep(3000);

        driver.quit();
    }
}