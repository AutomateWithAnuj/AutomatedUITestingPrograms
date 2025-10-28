package com.AutomateWithAnuj._28_DataDrivenTesting;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium53_DDT_NoFileOnlyDataProvider extends TestSelenium09_CommonToAll {
    @Test(dataProvider = "getData")
    public void test_vwo_login(String username, String password) {
        driver.navigate().to("https://app.vwo.com/#/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));

        WebElement E_userid = driver.findElement(By.xpath("//input[@id='login-username']"));
        WebElement E_password = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement E_login = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        WebElement E_errorMsg = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));

        E_userid.sendKeys(username);
        E_password.sendKeys(password);
        E_login.click();

        E_userid.clear();
        E_password.clear();

        Assert.assertEquals(E_errorMsg.getText(),"Your email, password, IP address or location did not match");
    }

    @DataProvider
    @Parameters()
    public Object[][] getData(){
        return new Object[][]{
            new Object[]{"admin123@gmail.com", "pass123"},
            new Object[]{"admin234@gmail.com", "pass234"},
            new Object[]{"admin456@gmail.com", "pass456"},
        };
    }
}
