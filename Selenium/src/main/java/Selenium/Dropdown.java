package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public class Dropdown
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        WebElement menu = driver.findElement(By.linkText("Drop-Down"));
        menu.click();

        WebElement Fruit = driver.findElement(By.xpath("//select[@id='fruits']"));
        Select one = new Select(Fruit);

        one.selectByVisibleText("Apple");

        WebElement  hero = driver.findElement(By.xpath("//select[@id='superheros']"));
        Select superhero = new Select(hero);
        boolean ismulti = superhero.isMultiple();
        System.out.println("Is multiple : "+ ismulti);

        superhero.selectByIndex(1);
        superhero.selectByValue("bp");

        List<WebElement> supers = superhero.getAllSelectedOptions();
        for(WebElement sh : supers)
        {
            System.out.println(sh.getText());
        }


        WebElement program = driver.findElement(By.xpath("//select[@id='lang']"));
        Select lastest = new Select(program);

        lastest.selectByValue("sharp");

        List<WebElement> allvalues = lastest.getOptions();

        for(WebElement values : allvalues)

        {
            System.out.println(values.getText());
        }


        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select onecoun = new Select(country);

        onecoun.selectByVisibleText("India");

        WebElement india = onecoun.getFirstSelectedOption();
        System.out.println(india.getText());



        //driver.quit();


    }

}
