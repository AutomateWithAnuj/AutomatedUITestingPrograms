package com.AutomateWithAnuj._22_FileUpload;

import com.AutomateWithAnuj._07_CommonToAllCode.TestSelenium09_CommonToAll;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TestSelenium37_FileUpload_RobotClass extends TestSelenium09_CommonToAll {
    @Test
    public void test_file_upload() throws InterruptedException, AWTException {
        driver.get("https://awesomeqa.com/selenium/upload.html");
        //WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
        //uploadFileInput.click(); //will throw the invalid argument exception
        //because the click action cannot be performed on the input element
        //so it's better to click using javascript executor

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", driver.findElement(By.id("fileToUpload")));
        //Only real user gestures (physical mouse clicks or touch actions) can open native OS dialogs.

        WebElement uploadButton = driver.findElement(By.id("fileToUpload"));
        // Locate the upload button on the webpage
        Point point = uploadButton.getLocation();
        // Get the button's location (X, Y) relative to the browser window (not the screen)
        System.out.println("X: " + point.getX() + " Y: " + point.getY());

        // Create a Robot class instance to control the mouse
        Robot robot = new Robot();
        // Move the mouse cursor to the approximate position of the upload button
        // ⚠️ Important:
        // The values returned by getLocation() are for the browser content area,
        // but Robot uses absolute screen coordinates.
        // So, we add an offset (here +10 and +130) to compensate for the browser's title bar,
        // address bar, and possible top padding.
        robot.mouseMove(point.getX()+10, point.getY()+130);
        // Perform a left-click on that position
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //now follow the 3 steps
        //1) copy the file path into the click board (Ctrl+C)
        StringSelection filePathSelection = new StringSelection("\"C:\\Users\\DELL\\Downloads\\data.txt\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
        //the above-mentioned code will capture the path into the clipboard

        Thread.sleep(3000);

        //2) now paste the path in filename input box (Ctrl+V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        //robot.keyPress(KeyEvent.VK_META); //for mac users
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);

        //3) click on return or enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.name("submit")).click();
    }
}
