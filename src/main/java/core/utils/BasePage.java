package core.utils;

import com.google.common.base.Predicate;
import com.wiley.driver.WebDriverFactory;
import com.wiley.holders.DriverHolder;
import org.apache.commons.io.input.BrokenInputStream;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.Driver;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.logging.Logger;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
    }

    public void init(WebDriver driver) {
        this.driver = driver;
        this.init();
    }

    protected void init() {
    }

    public final void open(String url) {
        if (!url.isEmpty()) {
            this.driver.get(url);
        }
    }

    public static Logger Log = Logger.getLogger(org.apache.commons.logging.Log.class.getName());

    public void openURL() {
        DriverHolder.getDriver().navigate().to(ReadConstants.prop.getProperty("url"));
    }
    public void setUp() {
        ReadConstants.readProperties();
        String browserName = ReadConstants.prop.getProperty("browser");
        initiateBrowser(browserName);
        openURL();
        maximizeWindow();
        Thread.sleep(1000);
    }

    protected String getDataFromHashMap(Hashtable<String,String> dataTable,String Key) {
        String returnValue ="";
        Map<String, String> tMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try {
            tMap.putAll(dataTable);
            returnValue = tMap.get(Key) == null ? "" : tMap.get(Key);
        } catch (Exception e) {
            System.out.println("Key Value is either null or doesn't exist");
        }
        return returnValue;
    }

    public void initiateBrowser(String Browser) {
        BrowserHandler browserHandler = new BrowserHandler();
        DesiredCapabilities cap = browserHandler.getDesiredCapability(Browser);
        WebDriverFactory.initDriver(cap);
        //maximizeWindow();
    }

    private void maximizeWindow() {
        DriverHolder.getDriver().manage().window().maximize();
    }
}
