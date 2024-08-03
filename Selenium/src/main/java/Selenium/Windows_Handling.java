package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Windows_Handling
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/windows");

        WebElement firstwindow = driver.findElement(By.xpath("//div[@class='control']//button[1]"));
        String url1 = driver.getWindowHandle();
        System.out.println("first window : "+url1);
        firstwindow.click();
        System.out.println(driver.getCurrentUrl());

        Set<String> windowhandle = driver.getWindowHandles();
        System.out.println(windowhandle);

        List<String> list = new ArrayList<>(windowhandle);
        driver.switchTo().window(list.get(0));
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());

        driver.switchTo().window(list.get(0)).close();


        driver.close();


    }
}
