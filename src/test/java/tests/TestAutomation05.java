package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.util.concurrent.TimeUnit;

public class TestAutomation05 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void interactWithDropDownMenu() throws InterruptedException {
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();

        Select ddSecurityQues = new Select(driver.findElement(By.id("securityQuestion")));
//        ddSecurityQues.selectByVisibleText("What is your Birth Place?");
//        ddSecurityQues.selectByValue("411010");
        ddSecurityQues.selectByIndex(0);
        Thread.sleep(5000);
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
