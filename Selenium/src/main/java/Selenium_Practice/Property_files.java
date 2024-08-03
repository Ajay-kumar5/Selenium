package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class Property_files
{
    void filecreate() throws IOException {

        Properties pros = new Properties();

        pros.setProperty("Username", "student");
        pros.setProperty("Password", "Password123");


        File filepath = new File("./sample.properties");
        FileOutputStream file = new FileOutputStream(filepath);
        pros.store(file, "Sample file foe demo");

        file.close();
    }

    void Readfile() throws IOException
    {
        Properties pros = new Properties();

        File filepath = new File("./sample.properties");
        FileInputStream file = new FileInputStream(filepath);
        pros.load(file);

        System.out.println(pros.getProperty("Username"));
        System.out.println(pros.getProperty("Password"));

        //capture all properties key value
        Set<String> keys = pros.stringPropertyNames();
        System.out.println(keys);

        //capture all properties key value - another methed
        Set<Object> allkeys = pros.keySet();
        System.out.println(allkeys);

        //capture all properties  value

        Collection<Object> values =pros.values();
        System.out.println(values);

        //read all data from properties
        for(String key : pros.stringPropertyNames() )
        {
            System.out.println(key+"  "+pros.getProperty(key));
        }

    }

    void login() throws IOException {
        Properties pros = new Properties();

        File filepath = new File("./sample.properties");
        FileInputStream file = new FileInputStream(filepath);
        pros.load(file);


        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
        user.sendKeys(pros.getProperty("Username"));

        WebElement pass= driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys(pros.getProperty("Password"));

        WebElement loginbut =  driver.findElement(By.xpath("//button[@id='submit']"));
        String  url = driver.getCurrentUrl();
        System.out.println("Login page url "+url);

        loginbut.click();
        String url2 = driver.getCurrentUrl();
        System.out.println("After login url "+url2);

        if(url2.contains("practicetestautomation.com/logged-in-successfully/"))
        {
            System.out.println("correct");
        }
        else
        {
            System.out.println("Not correct");
        }


        WebElement logout = driver.findElement(By.linkText("Log out"));

        if(logout.isDisplayed())
        {
            System.out.println("Is display");
        }
        else
        {
            System.out.println("Not display");
        }

        driver.quit();

    }



    public static void main(String[] args) throws IOException {

        Property_files obj = new Property_files();
        obj.login();
    }
}
