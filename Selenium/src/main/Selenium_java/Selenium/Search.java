package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class Search
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        search.sendKeys("acc");

        Thread.sleep(30000);
        List<WebElement> values = driver.findElements(By.xpath("//div[@role='presentation']"));

        for (WebElement  multi : values)
        {
            if(multi.getText().equalsIgnoreCase("accenture"))
            {
                System.out.println(multi.getText());
                multi.click();

            }
           
        }


        driver.quit();
    }
}
