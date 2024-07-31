package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Inputs
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement input = driver.findElement(By.linkText("Edit"));
        input.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='fullName']"));
        name.sendKeys("Ajy kumar");

        WebElement tab = driver.findElement(By.xpath("//input[@id='join']"));
        tab.sendKeys("boy", Keys.TAB);

        WebElement read = driver.findElement(By.xpath("//input[@id='getMe']"));
        String myvalue = read.getAttribute("value");
        System.out.println(myvalue);

        WebElement clear = driver.findElement(By.xpath("//input[@id='clearMe']"));
        clear.clear();

        WebElement disable = driver.findElement(By.xpath("//input[@id='noEdit']"));
        boolean textfield = disable.isEnabled();
        System.out.println(textfield);

        WebElement readonly = disable.findElement(By.xpath("//input[@id='dontwrite']"));
        String isreadonly = readonly.getAttribute("readonly");
        System.out.println(isreadonly);

    }
}
