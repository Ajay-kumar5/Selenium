package Selenium_Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShots
{
    void Pageshot() throws IOException

    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.w3schools.com/sql/");

        TakesScreenshot scrshot = ((TakesScreenshot) driver);

        File source = scrshot.getScreenshotAs(OutputType.FILE);
        File path = new File("D:\\screenshot\\img.png");
        FileHandler.copy(source, path);


        driver.quit();
    }

    void Buttonshot() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.w3schools.com/sql/");

        WebElement button = driver.findElement(By.xpath("//a[@class='w3-left w3-btn']"));

        File source = button.getScreenshotAs(OutputType.FILE);
        File path = new File("D:\\screenshot\\img2.png");
        FileHandler.copy(source, path);


        driver.quit();
    }

    public static void main(String[] args) throws IOException {
        ScreenShots obj = new ScreenShots();
        obj.Buttonshot();
    }

}
