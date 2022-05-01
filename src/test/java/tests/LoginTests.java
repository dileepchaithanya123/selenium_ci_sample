package tests;

import com.wiley.holders.DriverHolder;
import core.utils.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.wiley.holders.DriverHolder.getDriver;

public class LoginTests extends BasePage {
        private LoginPage loginPage;
        private HomePage homePage;

    private void initializeObjects(){
        loginPage = new LoginPage(DriverHolder.getDriver());
        homePage = new HomePage(DriverHolder.getDriver());

    }

    @BeforeTest
    public void initiateTest() {
        setUp();
    }

    /**
     * Verify the Login Section
     */
    @Test(description = "Login")
    public void verifyLoginFunctionality() {
        initializeObjects();
        loginPage.checkLoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        //loginPage.takeLoginPageScreenshot();
        loginPage.clickOnSubmitButton();
        homePage.checkHomePage();
        //homePage.takeHomePageScreenshot();
        homePage.clickOnLogoutButton();
    }

    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }


}
