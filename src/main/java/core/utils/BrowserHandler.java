package core.utils;

import groovy.json.internal.Chr;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class BrowserHandler {
    private DesiredCapabilities cap = new DesiredCapabilities();
    public static final String CONSTANT_NATIVEEVENTS ="nativeEvents";

    public DesiredCapabilities getDesiredCapability(String browser) {
        switch (browser.toLowerCase()) {
            case "ie":
                return getIECapabilities();
            case "edge":
                return getEdgeCapabilities();
            case "chrome":
                return getChromeCapabilities();
            case "firefox":
            default:
                return getFirefoxCapabilities();
        }
    }

    private DesiredCapabilities getChromeCapabilities() {
        cap = DesiredCapabilities.chrome();
        ChromeOptions options  = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-ssl-error=yes","--ignore-certificate-errors");
        options.setExperimentalOption("w3c",false);
        cap.setCapability(CONSTANT_NATIVEEVENTS,false);
        cap.setCapability("w3c",false);
        cap.setJavascriptEnabled(true);
        cap.setCapability("chrome.binary","C:\\Users\\dilee\\IdeaProjects\\selenium_ci_sample\\src\\main\\resources\\Drivers\\chromedriver.exe");
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability("goog:loggingPrefs",loggingPreferences);
        cap.setCapability(ChromeOptions.CAPABILITY,options);
        return cap;
    }

    private DesiredCapabilities getFirefoxCapabilities() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\dilee\\IdeaProjects\\selenium_ci_sample\\src\\main\\resources\\Drivers\\geckodriver.exe");
        cap = DesiredCapabilities.firefox();
        cap.setPlatform(Platform.ANY);
        cap.setCapability("marionette",true);
        return cap;
    }

    private DesiredCapabilities getEdgeCapabilities() {
        cap = DesiredCapabilities.edge();
        EdgeOptions option = new EdgeOptions();
        cap.setCapability("edgeOptions",option);
        return cap;
    }

    private DesiredCapabilities getIECapabilities() {
        cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
        cap.setCapability(CONSTANT_NATIVEEVENTS,false);
        cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        return cap;
    }
}
