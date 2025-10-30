package com.AutomateWithAnuj._28_DataDrivenTesting;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium54_DDT_FileOnlyDataProvider extends TestSelenium09_CommonToAll {
    @Test(dataProvider = "getData")
    public void test_vwo_login(String username, String password) {
            if (username == null || password == null) {
                return;
            }

        driver.navigate().to("https://app.vwo.com/#/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));

        WebElement E_userid = driver.findElement(By.xpath("//input[@id='login-username']"));
        WebElement E_password = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement E_login = driver.findElement(By.xpath("//button[@id='js-login-btn']"));

        E_userid.sendKeys(username);
        E_password.sendKeys(password);
        E_login.click();

        E_userid.clear();
        E_password.clear();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js-notification-box-msg']")));
        WebElement E_errorMsg = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));

        Assert.assertEquals(E_errorMsg.getText(),"Your email, password, IP address or location did not match");
    }

    @DataProvider
    @Parameters()
    public Object[][] getData(){
        //Read the Excel file
        //convert the row and column into the data[][] which is 2D array
        //return new Object[][];
        return UtilExcel.getTestDataFromExcel("Sheet2");
    }
}
