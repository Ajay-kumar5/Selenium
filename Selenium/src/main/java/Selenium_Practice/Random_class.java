package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Random_class
{
    void form() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Register.html");

        driver.manage().window().maximize();

        Random ran = new Random();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'form-control ng-pristine')])[1]"));
        String fName =  generateRandomString(5);
        firstname.sendKeys(fName);

        Thread.sleep(3000);

        WebElement lastname = driver.findElement(By.xpath("(//div[contains(@class,'col-md-4 col-xs-4')]//input)[2]"));
        String lName = generateRandomString(5);
        lastname.sendKeys(lName);

        WebElement Address = driver.findElement(By.xpath("//textarea[contains(@class,'form-control ng-pristine')]"));
        String Add = generateRandomString(15);
        Address.sendKeys(Add);

        WebElement email = driver.findElement(By.xpath("(//input[contains(@class,'form-control ng-pristine')])[3]"));
        String mail = generateRandomString(6)+"@gmail.com";
        email.sendKeys(mail);

        WebElement phonenumber = driver.findElement(By.xpath("//input[@type='tel']"));
        long phone = (long) (Math.random() * 10000 + 9586878974L);
        String Pnumber = Long.toString(phone);
        phonenumber.sendKeys(Pnumber);

        List<WebElement> gender = driver.findElements(By.xpath("//input[@name='radiooptions']"));
        gender.get(ran.nextInt(gender.size())).click();

        List<WebElement> hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
        hobbies.get(ran.nextInt(hobbies.size())).click();

        WebElement dropdown = driver.findElement(By.xpath("//div[@id='msdd']"));
        dropdown.click();

        List<WebElement> language = driver.findElements(By.xpath("//li[@class='ng-scope']"));
        int list1 = ran.nextInt(language.size());
        language.get(list1).click();

        Thread.sleep(3000);

        WebElement day = driver.findElement(By.xpath("//select[@id='daybox']//option"));
        day.click();

        Thread.sleep(3000);

        WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='Skills']"));
        dropdown1.click();

        List<WebElement> skills = driver.findElements(By.xpath("//select[@id='Skills']//option"));
        int list2 = ran.nextInt(skills.size());
        skills.get(list2).click();

        WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='country']//option"));
        dropdown2.click();

        List<WebElement> country = driver.findElements(By.xpath("//select[@id='country']//option"));
        int list3 = ran.nextInt(country.size());
        country.get(list3).click();

        WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='yearbox']//option"));
        dropdown3.click();
        Select year = new Select(dropdown3);
        year.selectByVisibleText("2020");



    }

    public static String generateRandomString(int length) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            Random random = new Random();
            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }

            return sb.toString();
        }

    public static void main(String[] args) throws InterruptedException {
        Random_class obj = new Random_class();
        obj.form();
    }

}
