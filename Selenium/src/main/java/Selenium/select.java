package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class select
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/selectable/#serialize");

        driver.manage().window().maximize();

        driver.switchTo().frame(0);

        List<WebElement> select = driver.findElements(By.cssSelector(".ui-widget-content.ui-selectee"));

/*Actions one = new Actions(driver);
        one.keyDown(Keys.CONTROL)
                        .sendKeys(Keys.chord("A"))
                                .keyUp(Keys.CONTROL)
                                        .perform();*/

        Actions one = new Actions(driver);
        WebElement start = select.get(0);
        WebElement stop = select.get(1);
        one.clickAndHold(start)
                .keyDown(Keys.CONTROL)
                .moveToElement(stop)
                .release()
                .keyUp(Keys.CONTROL)
                .perform();


     //  driver.quit();

    }
}
