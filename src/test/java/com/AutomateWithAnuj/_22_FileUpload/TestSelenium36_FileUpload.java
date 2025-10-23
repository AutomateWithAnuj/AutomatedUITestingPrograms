package com.AutomateWithAnuj._22_FileUpload;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium36_FileUpload extends TestSelenium09_CommonToAll {
    @Test
    public void test_file_upload(){
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

        String working_dir = System.getProperty("user.dir");
        String path_file = working_dir+"/src/test/java/com/AutomateWithAnuj/Data/data.txt";
        uploadFileInput.sendKeys(path_file);

        driver.findElement(By.name("submit")).click();
    }
}
