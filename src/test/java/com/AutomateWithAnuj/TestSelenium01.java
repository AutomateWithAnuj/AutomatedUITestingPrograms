package com.AutomateWithAnuj;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Test
    public void test_openVWOLoginPage(){
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://app.vwo.com");
        System.out.println(edgeDriver.getTitle());
    }
}
