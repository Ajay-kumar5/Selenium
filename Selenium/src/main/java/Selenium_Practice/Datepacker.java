package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datepacker
{
    public static void main(String[] args) throws InterruptedException {

        Date today = new Date();
        SimpleDateFormat n = new SimpleDateFormat("dd-MM-yyyy");
        String datetoday = n.format(today);
        System.out.println(datetoday);

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\126\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mycontactform.com/samples.php?lerr=3");

        WebElement date = driver.findElement(By.id("q7"));
        date.sendKeys(datetoday);

        Thread.sleep(20000);

        driver.quit();

    }
}
