package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;

public class LaunchBrowserTest {
    WebDriver driver;
    @Test
    public void testShopDemoLaunch(){
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
        Assert.assertEquals(driver.getTitle(),"Home");
    }
    @BeforeTest
    public void beforeTest(){
//        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
        driver = DriverUtil.getBrowserInstance("chrome");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest(){

    }
}
