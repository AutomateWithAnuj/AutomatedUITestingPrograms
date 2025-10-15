package com.AutomateWithAnuj._15_WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium20_TestStaticWebTables {
    @Test(groups = "QA")
    @Description("Fetching web tables data")
    public void FetchWebTablesData(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        //table[@id='customers']/tbody/tr[5]/td[2]

        //table[@id='customers']/tbody/tr
        //i
        //]/td[
        //j
        //]

        String first_part = "//table[@id='customers']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        //int row = driver.findElements(By.tagName("tr")).size();
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        //first row is header so we need to start from the 2nd row
        //in the table data we always start from the tr[1] or td[1] like the roll numbers
        for(int i=2;i<=row;i++){
            for(int j=1;j<=col;j++){
                String dynamic_path = first_part + i + second_part + j +third_part;
//                System.out.println(dynamic_part); //check all xpath by this
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                System.out.println(data);
                if(data.contains("Helen Bennett")) {
                    String country_path = dynamic_path + "/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("------");
                    System.out.println("Helen Bennett is in - " + country_text);
                }
            }
        }
        driver.quit();
    }
}
