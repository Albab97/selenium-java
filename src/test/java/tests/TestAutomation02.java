package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.util.concurrent.TimeUnit;

public class TestAutomation02 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void productSearchUsingXPath(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.xpath("//a[@href='login.htm']")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("testuser01");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pass123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
//        driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/input")).sendKeys("Gift set");
//        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@href='fetchorder.htm']/span")).click();
        String product = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[@class='hidden-sm']")).getText();
        Assert.assertEquals(product,"Headphone");
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
