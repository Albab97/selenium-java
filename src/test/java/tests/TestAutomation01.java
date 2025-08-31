package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.awt.desktop.SystemEventListener;
import java.util.concurrent.TimeUnit;

public class TestAutomation01 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void userLoginLogoutCSSSelector(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.cssSelector("a[href='login.htm']")).click();
        driver.findElement(By.cssSelector("input#userName")).sendKeys("testuser01");
        driver.findElement(By.cssSelector("input#password")).sendKeys("pass123");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.cssSelector("a[href='logout.htm']")).click();
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
