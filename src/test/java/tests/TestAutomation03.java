package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.util.concurrent.TimeUnit;

public class TestAutomation03 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void loginWithInvalidCreds(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.linkText("SignIn")).click();
        driver.findElement(By.id("userName")).sendKeys("testuser01");
        driver.findElement(By.id("password")).sendKeys("pass234");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String errorMessage = driver.findElement(By.xpath("//div[@id='errormsg'][2]")).getText();
        Assert.assertEquals(errorMessage,"Username or Password is wrong here!!!");
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
