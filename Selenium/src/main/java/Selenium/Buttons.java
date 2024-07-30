package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Buttons
{
    void Buttonposoition()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement buttonclick = driver.findElement(By.xpath("//a[@href='/buttons']"));
        buttonclick.click();

        WebElement buttonposition = driver.findElement(By.xpath("//button[@id='position']"));
        Point position = buttonposition.getLocation();
        int x = position.getX();
        int y = position.getY();

        System.out.println("X value :"+x+"  Y value :"+y);

        driver.quit();
    }

    void  Buttonsize()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement buttonclick = driver.findElement(By.xpath("//a[@href='/buttons']"));
        buttonclick.click();

        WebElement buttonsize = driver.findElement(By.xpath("//button[@id='property']"));
        int h = buttonsize.getSize().height;
        int w = buttonsize.getSize().width;

        System.out.println("Heigth : "+h+" width : "+w);

        driver.quit();
    }

    void Buttoncolour()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement buttonclick = driver.findElement(By.xpath("//a[@href='/buttons']"));
        buttonclick.click();

        WebElement buttoncolour = driver.findElement(By.xpath("//button[@id='color']"));
        String colour = buttoncolour.getCssValue("background-color");
        

        System.out.println(colour);

        driver.quit();
    }

    void Click_hold()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement buttonclick = driver.findElement(By.xpath("//a[@href='/buttons']"));
        buttonclick.click();

        WebElement clicks = driver.findElement(By.xpath("//div[6]/div/button[@id='isDisabled']"));
        Actions hold = new Actions(driver);
        hold.clickAndHold(clicks);
        hold.perform();


    }



    public static void main(String[] args)
    {
        Buttons obj  = new Buttons();
        obj.Click_hold();
    }
}
