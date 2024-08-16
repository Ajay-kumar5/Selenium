package TestNG_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;

public class Groups
{
    WebDriver driver;

    @FindBy(id = "foobar") WebElement foobar;

    @BeforeTest
    public void start_point()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\126\\chromedriver.exe");
        System.out.println("This is the starting point of the test");
        driver = new ChromeDriver();
        driver.get("https://seleniumbase.io/demo_page");
    }

    @Test(groups = "check")
    public  void Check_Title()
    {
        String testTitle = "Web Testing Page";
        String originalTitle = driver.getTitle();
        System.out.println(originalTitle);
        Assert.assertEquals(originalTitle, testTitle);

    }

    @Test(groups = "check")
    public void element() {
        WebElement Text = driver.findElement(By.xpath("//input[@id='myTextInput']"));
        Text.sendKeys("Ajay");
        System.out.println("Home Page Heading is displayed");
    }
    @Test
    public void Textarea()
    {
        WebElement area = driver.findElement(By.xpath("//textarea[@id='myTextarea']"));
        area.sendKeys("Welcome to TestNG");
        System.out.println("Second Page");
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }

}

