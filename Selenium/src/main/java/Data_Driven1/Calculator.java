package Data_Driven1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Calculator
{
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");

        driver.manage().window().maximize();

        File file = new File("./Data-Driven Test1.xlsx");
        String filepath = file.getPath();

        int rows = ExcelUtils.getRowcount(filepath,"Sheet1");

        System.out.println(rows);

        for(int i = 1;i<=rows;i++)
        {

            String Principal = ExcelUtils.getcelldata(filepath,"Sheet1",i,0);
            String Rate  = ExcelUtils.getcelldata(filepath,"Sheet1",i,1);
            String Period1  = ExcelUtils.getcelldata(filepath,"Sheet1",i,2);
            String Period2 = ExcelUtils.getcelldata(filepath,"Sheet1",i,3);
            String Frequency = ExcelUtils.getcelldata(filepath,"Sheet1",i,4);
            String Exp_value = ExcelUtils.getcelldata(filepath,"Sheet1",i,5);


            WebElement pri = driver.findElement(By.xpath("//input[@id='principal']"));
            pri.sendKeys(Principal);

            WebElement rate = driver.findElement(By.xpath("//input[@id='interest']"));
            rate.sendKeys(Rate);

            WebElement per1 = driver.findElement(By.xpath("//input[@id='tenure']"));
            per1.sendKeys(Period1);

            WebElement per2 = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
            Select s1 = new Select(per2);
            s1.selectByVisibleText(Period2);

            WebElement fre = driver.findElement(By.xpath("//select[@id='frequency']"));
            Select s2 = new Select(fre);
            s2.selectByVisibleText(Frequency);

            WebElement cal = driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
            cal.click();


            WebElement act_value = driver.findElement(By.xpath("//span[@id='resp_matval']"));
            String x = act_value.getText();

            if(Double.parseDouble(Exp_value)==Double.parseDouble(x))
            {
                System.out.println("Test Passed");
                ExcelUtils.setCelldata(filepath,"Sheet1",i,7,"Passed");
                //ExcelUtils.fillGreencolor(filepath,"Sheet1",i,7);
            }
            else
            {
                System.out.println("Test Failed");
                ExcelUtils.setCelldata(filepath,"Sheet1",i,7,"Failed");
                //ExcelUtils.fillRedcolor(filepath,"Sheet1",i,7);
            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]")).click();


        }

        driver.quit();

    }

}
