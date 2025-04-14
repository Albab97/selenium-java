package demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass03 {
    @BeforeMethod
    public void beforeM(){
        System.out.println("In before test method");
    }
    @AfterMethod
    public void afterM(){
        System.out.println("In after test method");
    }

    @Test(dataProvider = "testDataGenerator")
    public void login(String username, String password){
        System.out.println(username+" "+ password);
    }
    @DataProvider
    public Object[][] testDataGenerator(){
        Object[][] data = {
                {"user01","pass123"},
                {"user02","pass345"},
                {"user03","pass567"}
        };
        return data;
    }

}
