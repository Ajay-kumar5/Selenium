package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Slider
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://seleniumbase.io/demo_page");

        driver.manage().window().maximize();


        WebElement slider = driver.findElement(By.xpath("//input[@id='mySlider']"));

        int xsize = slider.getLocation().getX();
        int ysize = slider.getLocation().getY();

        System.out.println(xsize);
        System.out.println(ysize);

        Actions action = new Actions(driver);
        action.dragAndDropBy(slider,-50,0).build().perform();

        Thread.sleep(10000);

        WebElement value = driver.findElement(By.xpath("//progress[@id='progressBar']"));
        String values =value.getAttribute("value");
        System.out.println(values);

         driver.quit();



    }
}
