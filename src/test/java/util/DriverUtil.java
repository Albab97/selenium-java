package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

    static public WebDriver getBrowserInstance(String browserName){
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
            return new ChromeDriver();
        }else{ // similarly you can add here other browser drivers
            return null;
        }
    }
}
