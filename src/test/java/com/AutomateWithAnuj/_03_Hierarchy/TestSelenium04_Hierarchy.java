package com.AutomateWithAnuj._03_Hierarchy;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestSelenium04_Hierarchy {
    //WebDriver hierarchy

    //SearchContext(I) - 2 methods
    //WebDriver(I) - 10 methods
    //RemoteWebDriver(C) - 15 methods
    //ChromiumDriver(C) - 25 methods - it is a free open source project - browser engine
    //ChromeDriver(C) - it is the chrome Driver created from chromium engine
    //EdgeDriver(C) - 45 methods - it is also created from the chromium engine.
    //GeckoDriver(C) - Firefox has the gecko engine
    //SafariDriver(C) - they have appleKit engine

    @Test
    public void Hierarchy() {
//        SearchContext driver1 = new ChromeDriver(); //Possible
//        SearchContext driver2 = new EdgeDriver(); //Possible
//        SearchContext driver3 = new FirefoxDriver(); //Possible
//        SearchContext driver4 = new InternetExplorerDriver(); //Possible
//        WebDriver drivera = new ChromeDriver(); //Possible
//        RemoteWebDriver driverb = new ChromeDriver(); //Possible
//        ChromeDriver driverc = new ChromeDriver(); // Possible

        //Scenarios
        // 1. Do you want to run on the chrome or edge anyone?
        ChromeDriver driverc = new ChromeDriver(); //1% time we use this

        // 2. Do you want to run on the chrome then change to Edge?
        WebDriver drivera = new ChromeDriver(); //Possible - 97% time we use this
        drivera = new EdgeDriver();
        drivera = new FirefoxDriver();

        // 3. do you want to run on the multiple browsers, aws machine?
        // RemoteWebDriver driver (with GRID) - Advance (Last 2 sessions) //2% time we use this
    }
}
