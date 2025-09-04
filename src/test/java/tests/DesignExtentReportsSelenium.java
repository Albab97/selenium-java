package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import util.DriverUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
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

        reports.setSystemInfo("user","albab.ahmed");
        reports.setSystemInfo("environment","test env");
        reports.setSystemInfo("location","DDC5E");

        sparkReporter.config().setDocumentTitle("Test Results");
        sparkReporter.config().setTheme(Theme.DARK);

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
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
            String destFile = System.getProperty("user.dir")+"/extent-reports/captures/"+result.getMethod().getMethodName()+".png";
            try {
                FileUtils.copyFile(srcfile,new File(destFile));
                testLog.addScreenCaptureFromPath(destFile);
                testLog.log(Status.FAIL, MarkupHelper.createLabel("This is a failed method", ExtentColor.RED));
                testLog.log(Status.FAIL,result.getThrowable().getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
