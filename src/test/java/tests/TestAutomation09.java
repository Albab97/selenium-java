package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestAutomation09 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void testAlerts() throws InterruptedException {
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        if(ExpectedConditions.alertIsPresent()!=null) {
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals(alert.getText(), "Please enter some product name");
            Thread.sleep(2000);
            alert.accept();
        }
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
