package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://letcode.in/test");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");


        WebElement menu = driver.findElement(By.xpath("//a[@href='/radio']"));
        menu.click();

        WebElement c1 = driver.findElement(By.xpath("//input[@id='yes']"));
        c1.click();


        WebElement c2 =  driver.findElement(By.xpath("//input[@id='one']"));
        WebElement c2_1 =  driver.findElement(By.xpath("//input[@id='two']"));

            if(c2.isSelected())
            {
                System.out.println("R2 Yes Already selected");
            }
            else if(c2_1.isSelected())
            {
                System.out.println("R2 No Already selected");

            }
            else
            {
                c2.click();
                c2_1.click();
                System.out.println("R2.selected only ones Yes "+  c2.isSelected());
                System.out.println("R2.selected only ones No "+  c2_1.isSelected());
            }



        WebElement c3 =  driver.findElement(By.xpath("//input[@id='nobug']"));
        WebElement c3_1 =  driver.findElement(By.xpath("//input[@id='bug']"));

            if(c3.isSelected())
            {
                System.out.println("R3 Yes Already selected");
            }
            else if(c3_1.isSelected())
            {
                System.out.println("R3 No Already selected");
            }
            else
            {
                c3.click();
                c3_1.click();
                System.out.println("R3.selected only ones yes "+  c3.isSelected());
                System.out.println("R3.selected only ones No "+  c3_1.isSelected());
            }



        WebElement c4 =  driver.findElement(By.xpath("//input[@id='foo']"));
        WebElement c4_1 =  driver.findElement(By.xpath("//input[@id='notfoo']"));

        if(c4.isSelected())
            {
                System.out.println("R4 Yes Already selected ");

            }
        else if (c4_1.isSelected())
            {
                System.out.println("R4 No Already selected ");
            }
        else
        {
            c4.click();
            c4_1.click();
            System.out.println("R4.selected only ones yes "+  c4.isSelected());
            System.out.println("R4.selected only ones No "+  c4_1.isSelected());
        }


        WebElement c5 = driver.findElement(By.xpath("//input[@id='maybe']"));

        if(c5.isEnabled())
        {
            System.out.println("R5 is enabled");
        }
        else
        {
            System.out.println("R5 is not enabled");
        }


        WebElement c6 = driver.findElement(By.xpath("//input[@type='checkbox']"));

        if(c6.isSelected())
        {
            System.out.println("R6 is already selected");
        }
        else
        {
            c6.click();
            System.out.println("R6 is selected");
        }

        WebElement c7 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if(c7.isSelected())
        {
            System.out.println("R7 is already selected");
        }
        else
        {
            c7.click();
            System.out.println("R7 is selected");
        }


        driver.quit();
    }

}
