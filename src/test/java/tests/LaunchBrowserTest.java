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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaunchBrowserTest {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
//        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void testShopDemoLaunch(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        Assert.assertEquals(driver.getTitle(),"Home");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int countOfLinks = allLinks.size();
        System.out.println("There are " + countOfLinks + " number of links.");
        for (int i = 0 ;i<countOfLinks;i++){
            String textValue = allLinks.get(i).getText();
            String hrefValue = allLinks.get(i).getAttribute("href");
            System.out.println(textValue+" : "+hrefValue);
        }
//        driver.findElement(By.partialLinkText("SignIn")).click();
//        WebElement userName = driver.findElement(By.id("userName"));
//        userName.sendKeys("Admin");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("password");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
