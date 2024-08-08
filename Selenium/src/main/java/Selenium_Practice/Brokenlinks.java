package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Brokenlinks
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://www.deadlinkcity.com/");

        driver.manage().window().maximize();

        int count = 0;

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links size: "+links.size());

        for(WebElement linkelements : links)
        {
            String hreflinks = linkelements.getAttribute("href");

            if(hreflinks==null ||hreflinks.isEmpty())
            {
                System.out.println("Where is no link in href, so we can not check");
                continue;
            }

            try
            {
                URL urllink = new URL(hreflinks);
                HttpURLConnection conn = (HttpURLConnection) urllink.openConnection();
                conn.connect();

                if(conn.getResponseCode()>=400)
                {
                    System.out.println("This code is broken: "+hreflinks);
                    count++;
                }
                else
                {
                    System.out.println("Not Broken links: "+ hreflinks);
                }
            }
            catch (Exception e)
            {

            }
        }
        System.out.println(count);

        driver.quit();
    }

}
