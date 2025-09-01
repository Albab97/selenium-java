package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestAutomation07 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public void mouseHoverTest() throws InterruptedException {
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span")))
                .moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our')]")))
                .moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Bangalore')]")))
                .click().build().perform();
//        Thread.sleep(5000);
    }
    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");

        WebElement dragElement = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
        WebElement dropElement = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement,dropElement).perform();

//        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[@id=\"ctl00_ContentPlaceholder1_Label1\"]"),"Drop a package here to check price"));

        String message = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
//        Assert.assertEquals(message,"The price of 'Weekend Package' is : $3999");
        Assert.assertTrue(message.contains("Weekend Package"));
        Assert.assertTrue(message.contains("$"));
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
