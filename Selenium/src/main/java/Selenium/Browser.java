package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Browser {
    void Login() {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\126\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mycontactform.com/samples.php?lerr=3");

        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("ABC");

        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    void form() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\126\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.mycontactform.com/samples.php?lerr=3");

        driver.findElement(By.xpath("//input[@name='email_to[]'] [position()=2]")).click();

        driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Applying for job");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xzy@gmail.com");

        driver.findElement(By.xpath("//input[@id='q1']")).sendKeys("Hello");

        driver.findElement(By.xpath("//textarea[@id='q2']")).sendKeys("Automation, the technological revolution transforming our world.\n" +
                "Machines and algorithms taking over tasks once done by human hands");

        driver.findElement(By.xpath("(//select[@id='q3']/option[3])")).click();

        driver.findElement(By.xpath("//input[@id='q4'] [position()=2]")).click();

        driver.findElement(By.xpath("//input[@id='q5']")).click();

        driver.findElement(By.xpath("//input[@name='checkbox6[]'] [position()=4]")).click();

        driver.findElement(By.xpath("//input[@id='q7']")).sendKeys("05-12-1999");

//        driver.findElement(By.xpath("(//select[@class='ui-datepicker-month']/option[12])")).click();
//
//        driver.findElement(By.xpath("(//select[@class='ui-datepicker-year']/option[76])")).click();
//
//        driver.findElement(By.xpath("//a[@class='ui-state-default'] [text()='16']")).click();

        driver.findElement(By.xpath("(//select[@id='q8']/option[20])")).click();

        driver.findElement(By.xpath("(//select[@id='q9']/option[10])")).click();

        driver.findElement(By.xpath("(//select[@id='q10']/option[5])")).click();

        driver.findElement(By.xpath("(//select[@name='q11_title']/option[4])")).click();

        driver.findElement(By.xpath("//input[@name='q11_first']")).sendKeys("AK");

        driver.findElement(By.xpath("//input[@name='q11_last']")).sendKeys("05");

        driver.findElement(By.xpath("(//select[@name='q12_month']/option[5])")).click();

        driver.findElement(By.xpath("(//select[@name='q12_day']/option[1])")).click();

        driver.findElement(By.xpath("(//select[@name='q12_year']/option[15])")).click();

        Thread.sleep(1000);

        File upload = new File("D:\\API Teating\\cats.json");
        WebElement file = driver.findElement(By.xpath("//input[@id='attach4589']"));
        file.sendKeys(upload.getAbsolutePath());

        Thread.sleep(1000);

        //driver.findElement(By.xpath("//input[@name='submit']")).click();

        //driver.findElement((By.xpath("//input[@name='reset']")) ).click();

        driver.findElement(By.xpath("//input[@value='Print']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//cr-button[@class='cacel-button']")).click();

        Thread.sleep(1000);

        driver.close();


    }

    public static void main(String[] args) throws InterruptedException {
        Browser ob = new Browser();
        ob.form();
    }

}
