package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Table {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/web-table-element.php");

        driver.get("https://demo.guru99.com/test/web-table-element.php");

        driver.manage().window().maximize();

        List<WebElement> row=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

        int rowsize=row.size();

        List<WebElement> column=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));

        int columnsize=column.size();

        for(int i=1;i<=rowsize;i++)



            for(int j=1;j<=columnsize;j++)

            {

                WebElement header=driver.findElement(By.xpath("//table[@class='dataTable']//th["+j+"]"));

                String header1=header.getText();

                WebElement data=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]"));

                String data1=data.getText();

                System.out.println(header1+ ":"+data1);

            }

        System.out.println("--------------------------------------------------------");


        driver.quit();


    }
}
