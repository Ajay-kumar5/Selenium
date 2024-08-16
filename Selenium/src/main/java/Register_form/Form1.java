package Register_form;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Form1
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\127\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.wpeverest.com/user-registration/student-registration-form/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        Locale locale = new Locale("en","INDIA");
        Faker faker = new Faker(locale);

        Random ran = new Random();


        WebElement fname = driver.findElement(By.xpath("//input[@id='first_name']"));
        WebElement lname = driver.findElement(By.xpath("//input[@id='last_name']"));
        WebElement mailid = driver.findElement(By.xpath("//textarea[@id='textarea_1623050614']"));
        WebElement city = driver.findElement(By.xpath("//input[@id='input_box_1623050696']"));
        WebElement state = driver.findElement(By.xpath("//input[@id='input_box_1623050759']"));
        state.sendKeys("Tamilnadu");

        WebElement country = driver.findElement(By.xpath("//select[@id='country_1623050729']"));
        country.click();

        List<WebElement> countrylist = driver.findElements(By.xpath("(//select[@id='country_1623050729']/option)"));
        int list = ran.nextInt(countrylist.size());
        countrylist.get(list).click();

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='input_box_1623050879']"));

        WebElement date = driver.findElement(By.xpath("//input[@data-label='Date of Birth']"));
        date.click();

        WebElement month = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        month.click();
        List<WebElement> monthlist = driver.findElements(By.xpath("//select[@aria-label='Month']/option"));
        int list2 = ran.nextInt(monthlist.size());
        monthlist.get(list2).click();

        WebElement year = driver.findElement(By.xpath("//input[@aria-label='Year']"));
        year.sendKeys(faker.numerify("4"));

        List<WebElement> alldates = date.findElements(By.xpath("//div[@class='dayContainer']/span"));

        for(WebElement single : alldates)
        {
            String x = single.getText();
            if(x.equals("4"))
            {
                single.click();
                break;
            }
        }

        List<WebElement> gender = date.findElements(By.xpath("//input[@type='radio']"));
        gender.get(ran.nextInt(gender.size())).click();

        WebElement student_mail = driver.findElement(By.xpath("//input[@id='user_email']"));

        WebElement comform_studmail = driver.findElement(By.xpath("//input[@id='user_confirm_email']"));

        WebElement password = driver.findElement(By.xpath("//input[@id='user_pass']"));

        WebElement comform_pass = driver.findElement(By.xpath("//input[@id='user_confirm_password']"));

        WebElement SLC = driver.findElement(By.xpath("//select[@id='select_1623053939']"));
        Select s1 = new Select(SLC);
        s1.selectByVisibleText("SLC");

        WebElement Plus2 = driver.findElement(By.xpath("//select[@id='select_1623075235990']"));
        Select s2 = new Select(Plus2);
        s2.selectByVisibleText("Plus 2");

        WebElement Bachelor = driver.findElement(By.xpath("//select[@id='select_1623075252220']"));
        Select s3 = new Select(Bachelor);
        s3.selectByVisibleText("Bachelor");

        WebElement school1 = driver.findElement(By.xpath("//input[@id='input_box_1623075201']"));
        school1.sendKeys("AET M.H.S.S");

        WebElement school2 = driver.findElement(By.xpath("//input[@id='input_box_1623075238301']"));
        school2.sendKeys("AET M.H.S.S");

        WebElement school3 = driver.findElement(By.xpath("//input[@id='input_box_1623075254142']"));
        school3.sendKeys("Gobi Arts & Science college");

        WebElement grade1 = driver.findElement(By.xpath("//input[@id='input_box_1623054140']"));

        WebElement grade2 = driver.findElement(By.xpath("//input[@id='input_box_1623075240823']"));

        WebElement grade3 = driver.findElement(By.xpath("//input[@id='input_box_1623075256147']"));

        WebElement mothername = driver.findElement(By.xpath("//input[@id='input_box_1623052350']"));

        WebElement fathername = driver.findElement(By.xpath("//input[@id='input_box_1623053158710']"));

        WebElement Address = driver.findElement(By.xpath("//textarea[@id='textarea_1623052454']"));

        List<WebElement> hobbies = driver.findElements(By.xpath("//input[@data-label='Hobbies']"));
        hobbies.get(ran.nextInt(hobbies.size())).click();

        WebElement decl = driver.findElement(By.xpath("//input[@id='privacy_policy_1623078743']"));
        decl.click();






        String Fname = faker.name().firstName();
        String Lname = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        String City = faker.address().city();
        String zip = faker.address().zipCode();
        String Studmail = faker.internet().emailAddress();
        String Pass = faker.internet().password(6,15);
        String G1 = String.valueOf(faker.number().randomDigitNotZero());
        String G2 = String.valueOf(faker.number().randomDigitNotZero());
        String G3 = String.valueOf(faker.number().randomDigitNotZero());
        String Mother = faker.name().fullName();
        String Father  = faker.name().fullName();
        String addr = faker.address().fullAddress();





        fname.sendKeys(Fname);
        lname.sendKeys(Lname);
        mailid.sendKeys(Email);
        city.sendKeys(City);
        zipcode.sendKeys(zip);
        student_mail.sendKeys(Studmail);
        comform_studmail.sendKeys(Studmail);
        password.sendKeys(Pass);
        comform_pass.sendKeys(Pass);
        grade1.sendKeys(G1);
        grade2.sendKeys(G2);
        grade3.sendKeys(G3);
        fathername.sendKeys(Mother);
        mothername.sendKeys(Father);
        Address.sendKeys(addr);

        WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submit.click();

        WebElement successful = date.findElement(By.xpath("//ul[contains (text(),'User successfully registered.')]"));
        System.out.println(successful.getText());

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successful));

        if(successful.getText().contains("successfully"))
        {
            System.out.println("Automatiom completed correctly");
        }
        else
        {
            System.out.println("Automatiom completed Incorrectly");
        }

        driver.quit();
    }



}
