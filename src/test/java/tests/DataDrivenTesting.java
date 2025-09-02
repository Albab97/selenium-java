package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.DriverUtil;
import util.ExcelUtil;

import java.util.concurrent.TimeUnit;

public class DataDrivenTesting {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test(dataProvider = "xlData")
    public void readDataFromExcelAndLogin(String email, String password, String type){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.linkText("SignIn")).click();
        driver.findElement(By.id("userName")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        boolean check = driver.findElement(By.xpath("//a[@href='logout.htm']")).isDisplayed();
        Assert.assertTrue(check);
        driver.findElement(By.partialLinkText("SignOut")).click();
    }
    @DataProvider(name = "xlData")
    public Object[][] getDataFromExcel(){
        return ExcelUtil.readDataFromExcel("TestData");
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
