package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenUrl;
import utils.ExtentReports.ExtentTestManager;
import utils.Listeners.TestListener;

import java.io.IOException;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.

    @Test (priority = 0, description="Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException, IOException {
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Invalid Login Scenario with wrong username and password.");

        //*************PAGE INSTANTIATIONS*************
        OpenUrl homePage = new OpenUrl(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Login to N11
        loginPage.loginToN11("onur@swtestahh.com", "11223344");

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        loginPage.verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test (priority = 1, description="Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException, IOException {
        //ExtentReports Description
        ExtentTestManager.getTest().
                setDescription("Invalid Login Scenario with empty username and password.");

        //*************PAGE INSTANTIATIONS*************
        OpenUrl homePage = new OpenUrl(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        homePage.goToN11();
        homePage.goToLoginPage();
        loginPage.loginToN11("","");

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        loginPage.verifyLoginUserName("Dieses Feld ist ein Pflichtfeld");
        loginPage.verifyLoginPassword("Dieses Feld ist ein Pflddd");
    }
/*
    @Test (priority = 0, description="valid Login Scenario with right username and password.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void validLoginTest_ValidUserNameValidPassword () throws InterruptedException, IOException {
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("valid Login Scenario with right username and password.");

        //*************PAGE INSTANTIATIONS*************
        OpenUrl homePage = new OpenUrl(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Login to N11
        loginPage.loginToN11("onur@swtestahh.com", "11223344");

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        loginPage.verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }
    */
}
