package demo;

import org.testng.annotations.Test;

public class TestClass02 extends BaseClass{
    // All test methods are by default executed in alphabetical order.
    //Priority allows us to decide the order of execution. If the priority of two or more methods are same then it will be executed in Alphabetical order.
    @Test(priority = 0)
    public void registration(){
        System.out.println("In the registration test method");
    }
    // enable will allow us to ignore/disable the execution of a particular test method. By default enable is true for all the methods.
    @Test(priority = 2, enabled = false)
    public void logout(){
        System.out.println("In the logout test method");
    }
    @Test(priority = 1)
    public void login(){
        System.out.println("In the login test method");
    }
}
