package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement buttonclick = driver.findElement(By.xpath("//a[@href='/buttons']"));
        buttonclick.click();

        WebElement home = driver.findElement(By.xpath("//button[@id='home']"));
        home.click();

        Thread.sleep(10000);

        driver.navigate().back();
        Thread.sleep(10000);

        driver.navigate().forward();
        Thread.sleep(10000);

        driver.navigate().refresh();




    }


}
