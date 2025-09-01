package tests;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestAutomation08 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public void keyBoardEventsTest() throws InterruptedException {
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        WebElement searchBox = driver.findElement(By.id("myInput"));

        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT)
                .sendKeys("W").pause(2000)
                .sendKeys("E").pause(2000)
                .sendKeys("A").pause(2000)
                .sendKeys("R").pause(2000)
                .keyDown(searchBox, Keys.SHIFT).build().perform();

        driver.findElement(By.xpath("//div[contains(text(),'Winter wear')]")).click();
//        Thread.sleep(2000);
    }
    @Test
    public void mouseAndKeyboardEvents(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .click(driver.findElement(By.linkText("SignIn")))
                .keyUp(Keys.SHIFT).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
