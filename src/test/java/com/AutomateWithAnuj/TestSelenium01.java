package com.AutomateWithAnuj;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Test
    public void test_openVWOLoginPage(){
        EdgeDriver edgeDriver = new EdgeDriver();
        //EdgeDriver the movement we have typed EdgeDriver class will be loaded in JVM as Class Loader
        //Driver instance or obj reference will be created first pointing to null area
        //new EdgeDriver(); will create the object of the class EdgeDriver and assigned to ref edgeDriver
        //when new EdgeDriver() is typed a http POST Request will go to the driver
            // which will create a new, real, browser fresh copy in heap area
            // and by that New Session in selenium is created
        // after creating a fresh copy we get a 16 digit unique session ID allocated to that copy of browser
            // we can run the commands into this session
        edgeDriver.get("https://app.vwo.com");
        // this is a get request which open the URL
        edgeDriver.quit();
        //now this is again a post request which will shut down the browser or Session==null
    }
}
