package tests;

import core.utils.BasePage;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BasePage {
        private WebDriver driver;

        private LoginPage loginPage;
        private HomePage homePage;

    private void initializeObjects(){
        loginPage = new LoginPage(driver);

    }

    @BeforeTest
    public void initiateTest() {
        setUp();
    }

    /**
     * Verify the Login Section
     */
    @Test
    public void verifyLoginFunctionality() {
        loginPage.checkLoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSubmitButton();
        loginPage.takeLoginPageScreenshot();
        homePage.checkHomePage();
        homePage.takeHomePageScreenshot();
        homePage.clickOnLogoutButton();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
