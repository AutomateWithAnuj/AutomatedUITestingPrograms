package com.AutomateWithAnuj._15_WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_TestDynamicWebTable {
    @Test(groups = "QA")
    @Description("Fetching web tables data")
    public void FetchWebTablesData() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        //as we know that dynamic webtable rows and columns are not equal
        //in this we are only printing the body

        //table[@Summary="Sample Table"] //table Xpath

        WebElement table = driver.findElement(By.xpath("//table[@Summary='Sample Table']/tbody"));

        //as this is having the structure like tbody -> tr -> th -> <td>
        //also we want to print th as well also column from 1 to all_column - 1 in the end

        List<WebElement> tr=  driver.findElements(By.tagName("tr"));
//        int cols = driver.findElements(By.xpath("//table[@Summary='Sample Table']/tbody/tr[1]/td")).size();

//        for (int i = 1; i <= rows; i++) {
//            String header = driver.findElement(By.xpath("//table[@Summary='Sample Table']/tbody/tr["+i+"]/th")).getText();
//            System.out.print(header + "    ");
//            for (int j = 1; j < cols; j++) {
//                String data = driver.findElement(By.xpath("//table[@Summary='Sample Table']/tbody/tr["+i+"]/td["+j+"]")).getText();
//                System.out.print(data + "    ");
//            }
//            System.out.println();
//        }
        for (WebElement row: tr){
            for (WebElement td: row.findElements(By.tagName("td"))) {
                System.out.println(td.getText());
            }
        }
    }
}
