package demo;

import org.testng.annotations.*;

public class TestClass01 {
    // Before method runs before every method
    @BeforeClass
    public void beforeClass(){
        System.out.println("In before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("In after class");
    }
    @BeforeMethod
    public void beforeM(){
        System.out.println("In before method");
    }
    // After method runs after every method
    @AfterMethod
    public void afterM(){
        System.out.println("In after method");
    }

    @Test
    public void method01(){
        System.out.println("In test method 01");
    }
    @Test
    public void method02(){
        System.out.println("In test method 02");
    }
    // method 03 will not run because of absence of @Test annotation.
    public void method03(){
        System.out.println("In test method 03");
    }
}
