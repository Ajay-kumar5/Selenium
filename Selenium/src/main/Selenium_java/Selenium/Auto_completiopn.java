package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Auto_completiopn {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\126\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        //clear the value
        WebElement searchclear=driver.findElement(By.xpath("//textarea[@name ='q']"));
        searchclear.clear();

        //Pass the vale
        WebElement search=driver.findElement(By.xpath("//textarea[@name='q']"));
        search.sendKeys("acc");

        List<WebElement> options=driver.findElements(By.xpath("(//ul[@role='listbox'])[1]"));
        int sizeoption=options.size();
        
        for(WebElement option1:options) {
            System.out.println(option1);
        }

        System.out.println(sizeoption);

        for (WebElement dropdownselect : options) {
            if (dropdownselect.getText().equalsIgnoreCase("accenture")) {
                dropdownselect.click();
                System.out.println(dropdownselect.getText());


            }


        }
        driver.quit();

    }
}


