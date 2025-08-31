package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestAutomation06 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void usingImplicitExplicitWait(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        driver.findElement(By.cssSelector("a[href='login.htm']")).click();
        driver.findElement(By.cssSelector("input#userName")).sendKeys("testuser01");
        driver.findElement(By.cssSelector("input#password")).sendKeys("pass123");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.cssSelector("a[href='logout.htm']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='login.htm']")));

        driver.findElement(By.linkText("SignIn")).click();
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
