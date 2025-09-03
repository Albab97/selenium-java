package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import util.DriverUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DesignExtentReportsSelenium {
    WebDriver driver;
    ExtentSparkReporter sparkReporter;
    ExtentReports reports;
    ExtentTest testLog;
    @BeforeClass
    public void beforeClass() {
        driver = DriverUtil.getBrowserInstance("chrome");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        String timestamp = sdf.format(new Date());
        String filePath = System.getProperty("user.dir")+"/extent-reports/"+timestamp+".html";
        sparkReporter = new ExtentSparkReporter(filePath);
        reports=new ExtentReports();
        reports.attachReporter(sparkReporter);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testMeApp() {
        testLog = reports.createTest("testMeApp");
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp");
        Assert.assertEquals(driver.getTitle(),"Home");
    }
    @Test(priority = 1)
    public void testGoogle() {
        testLog = reports.createTest("testGoogle");
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"MVN");
    }
    @Test(priority = 2)
    public void testYahoo() {
        testLog = reports.createTest("testGoogle");
        driver.get("https://www.yahoo.com/");
        throw new SkipException("This function is skipped");
    }
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus()== ITestResult.SUCCESS){
            testLog.log(Status.PASS,"This is in "+result.getMethod().getMethodName());
        }
        else if(result.getStatus()==ITestResult.FAILURE){
            testLog.log(Status.FAIL,"This is in "+result.getMethod().getMethodName());
        }else if(result.getStatus()==ITestResult.SKIP){
            testLog.log(Status.SKIP,"This is in "+result.getMethod().getMethodName());
        }
    }
    @AfterClass
    public void afterClass() {
        reports.flush();
        driver.quit();
    }
}
