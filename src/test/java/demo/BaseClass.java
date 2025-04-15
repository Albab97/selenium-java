package demo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//This is a base class which will act as a parent class to TestCase02, TestCase05, TestCase06, TestCase07 because all these classes have keyword 'extends'
public class BaseClass {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("In before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("In after suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("In before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("In after test");
    }
}
