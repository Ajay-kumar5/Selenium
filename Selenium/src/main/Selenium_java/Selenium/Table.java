package Selenium;

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

        List<WebElement> tab = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td"));


            for (int i = 0; i <tab.size(); i++)
            {
                System.out.println("company = " + tab.get(i).getText());

                for (int j = 1; j < 2 ; j++) {
                    System.out.println("Group  = " + tab.get(j).getText());

                    for (int z = 2; z < 3; z++) {
                        System.out.println("Prev Price(Rs.)  = " + tab.get(z).getText());

                        for (int a = 3; a < 4; a++) {
                            System.out.println("current Price(Rs.)  = " + tab.get(a).getText());

                            for (int b = 4; b < 5; b++) {
                                System.out.println("% change  = " + tab.get(b).getText());
                            }
                        }
                    }
                }
            }


        driver.quit();


    }
}
