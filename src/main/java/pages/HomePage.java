package pages;

import core.utils.BasePage;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class HomePage extends BasePage {


    private WebDriver driver;

    private static final By GURU_BANK_HEADER = By.xpath("//h2[text()='Guru99 Bank']");
    private static final By NEW_CUSTOMER_LINK = By.xpath("//a[text()='New Customer']");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Log out']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        init(driver);
    }

    public void checkHomePage() {
        driver.findElement(GURU_BANK_HEADER).isDisplayed();
    }

    public void clickOnLogoutButton() {
        driver.findElement(LOGOUT_LINK).click();
    }

    public void takeHomePageScreenshot() {
        WebElement elementLogo = driver.findElement(GURU_BANK_HEADER);

        File src = elementLogo.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") +    "/screenshots/HomePage.png");

        try {
            FileHandler.copy(src, dest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
