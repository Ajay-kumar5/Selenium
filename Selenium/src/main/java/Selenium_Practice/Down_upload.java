package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Down_upload
{
     void  download()
     {
         System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

         WebDriver driver = new ChromeDriver();

         ChromeOptions options = new ChromeOptions();
         Map<String, Object> prefs = new HashMap<String, Object>();
         prefs.put("download.default_directory", "/directory/path");
         options.setExperimentalOption("prefs", prefs);

         driver.get("");

         WebElement x = driver.findElement(By.xpath(" "));
         x.click();
     }

     void upload()
     {
         System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

         WebDriver driver = new ChromeDriver();

         driver.get("https://www.mycontactform.com/samples.php?lerr=3");

         WebElement up = driver.findElement(By.xpath("//input[@id='attach4589']"));
         File path = new File("D:\\API Teating\\cats.json");

         if(up.isEnabled())
         {
             up.sendKeys(path.getAbsolutePath());
             System.out.println("Uploaded");
         }
         else
         {
             System.out.println("Not Uploaded");
         }

     }

    public static void main(String[] args) {
        Down_upload obj = new Down_upload();
        obj.upload();
    }

}
