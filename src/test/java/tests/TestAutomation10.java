package tests;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestAutomation10 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void handleMultipleWindows() throws InterruptedException {
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]")))
                .moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our')]")))
                .click(driver.findElement(By.xpath("//ul/li[@class='sublast']/a/span[contains(text(),'Bangalore')]")))
                .build().perform();
        Thread.sleep(3000);
        String currentWindow = driver.getWindowHandle(); // returns a reference window id of the current window
        Set<String> windows = driver.getWindowHandles(); // returns a set of String of reference ids of the all the windows opened in the session in the order of opening.

        driver.switchTo().window(windows.toArray()[1].toString());
        Assert.assertEquals(driver.getTitle(),"Contact Us");

//        driver.switchTo().window(currentWindow);
    }
    @AfterTest
    public void afterTest(){
        driver.close();
//        driver.quit();
    }
}
