package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_drop
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/dropable");

        driver.manage().window().maximize();

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = drag.findElement(By.xpath("//div[@id='droppable']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(drag,drop).perform();



    }
}
