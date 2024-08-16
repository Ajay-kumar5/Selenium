package TestNG_Demo;

import org.testng.annotations.*;

public class Demo1 {
    @Test
    public void f() {
        System.out.println("First test cases");

    }

    @Test
    public void f1() {
        System.out.println("Second 0f case");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am before method");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am after method");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I am before class");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am after class");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I am before Test");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("I am after Test");

    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I am before suite");

    }
}
