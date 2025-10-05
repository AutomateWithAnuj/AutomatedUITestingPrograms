package com.AutomateWithAnuj._12_MiniProject2;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium09_MiniProject_ApplyAddRemovalExtension {
    //1. You need to open the YouTube.com
    //2. You need an extension which blocks the ads
    //3. URL for extension - https://chromewebstore.google.com/detail/adblock-%E2%80%94-block-ads-acros/gighmmpiobklfepjocnamgkkbiglidom?form=MG0AV3&pli=1
    //you cannot click the button now so we will not do that
    //Install this CRX Extractor/Downloader before https://chromewebstore.google.com/detail/crx-extractordownloader/ajkhmmldknmfjnmeedkbkkojgobmljda
    //so you need to click the download the CRX file for the Adblock extension
    //then a .crx file will be created which is the similar to .zip file
    //
    @Description("Options Class")
    @Test
    public void testSelenium() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1080"); //Windows size as HD we have added
        //now copy and paste the downloaded file into this package
        //now copy the path and give that path
        edgeOptions.addExtensions(new File("C:\\Users\\DELL\\IdeaProjects\\AutomatedUITestingPrograms\\src\\test\\java\\com\\AutomateWithAnuj\\_12_MiniProject2\\AdBlock.crx"));
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");
        driver.quit();
    }
}
