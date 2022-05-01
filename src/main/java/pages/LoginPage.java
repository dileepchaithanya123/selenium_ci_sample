package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class LoginPage {

    private WebDriver driver;

    private static final By USERNAME_FIELD = By.name("uid");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By SUBMIT_BTN = By.name("btnLogin");
    private static final By RESET_BTN = By.name("btnReset");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLoginPage() {
        driver.findElement(USERNAME_FIELD).isDisplayed();

    }

    public void enterUsername() {
        driver.findElement(USERNAME_FIELD);
    }
    public void enterPassword() {
        driver.findElement(PASSWORD_FIELD);
    }
    public void clickOnSubmitButton() {
        driver.findElement(SUBMIT_BTN);
    }

    public void clickOnResetButton() {
        driver.findElement(RESET_BTN);
    }

    public void takeLoginPageScreenshot() {
        WebElement elementLogo = driver.findElement(USERNAME_FIELD);

        File src = elementLogo.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") +    "/screenshots/LoginPage.png");

        try {
            FileHandler.copy(src, dest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}


