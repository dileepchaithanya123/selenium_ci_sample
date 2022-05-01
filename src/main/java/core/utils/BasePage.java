package core.utils;

import com.google.common.base.Predicate;
import org.apache.commons.io.input.BrokenInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.function.Function;

public class BasePage {

    private WebDriver driver;
    public void initializeBrowser(String Browser){
            if (Browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\dilee\\IdeaProjects\\selenium_ci_sample\\src\\main\\resources\\Drivers\\chromedriver.exe");
                WebDriver driver=new ChromeDriver();
            }

    }
    public void openURL() {
        driver.navigate().to(ReadConstants.prop.getProperty("url"));
    }
    public void setUp() {
        ReadConstants.readProperties();
        initializeBrowser(ReadConstants.prop.getProperty("browser"));
        openURL();
    }
}
