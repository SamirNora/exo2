package pages;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class LoginPage extends BasePage {
        //*********Constructor*********
        public LoginPage(WebDriver driver, WebDriverWait wait) throws IOException {
            super(driver, wait);
        }

        //*********Web Elements*********
    /**
     *
     */
    //without file excel

        String usenameId = "j_username";
        String passwordId = "j_password";
       // String loginButtonId = "(//input[@type='submit'])";
        String loginButtonId = "(//*[@id=\"js-login-form\"]/div/div/input)";

    //with excel file
            /*
    File src = new File("C:\\Users\\CDS_Admin\\IdeaProjects\\ExtentReportsExample-master\\ExtentReportsExample-master\\Dataset for Login.xlsx");
    FileInputStream fis = new FileInputStream(src);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet login = wb.getSheet("login");
   // String username = login.getRow(1).getCell(5).getStringCellValue();
    //String password = login.getRow(2).getCell(5).getStringCellValue();
    String usernameID = login.getRow(1).getCell(3).getStringCellValue();
    String passwordID = login.getRow(2).getCell(3).getStringCellValue();
    String loginButtonID = login.getRow(3).getCell(4).getStringCellValue();
   // String logoutpath = login.getRow(4).getCell(7).getStringCellValue();
   // String logoutname = login.getRow(4).getCell(4).getStringCellValue();
*/
        // 1 ere solu
    //   String errorMessageUsernameXpath = "//*[@id=\"js-login-form\"]/fieldset/div/div";
    // 2 ere solu
    String errorMessageUsernameXpath = "(//span[@for='j_username'])";
     //   String errorMessagePasswordXpath = "//*[@id=\"js-login-form\"]/fieldset/div/div";
    String errorMessagePasswordXpath = "(//*[@id=errormessage-j_password)";


        //*********Page Methods*********
        @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
        public void loginToN11 (String username, String password){
            //Enter Username(Email)
            writeText(By.id(usenameId),username);
            //Enter Password
            writeText(By.id(passwordId), password);
            //Click Login Button
            click(By.xpath(loginButtonId));
        }

        //Verify Username Condition
        @Step("Verify username: {0} step...")
        public void verifyLoginUserName (String expectedText) {
            Assert.assertEquals(readText(By.xpath(errorMessageUsernameXpath)), expectedText);
        }

        //Verify Password Condition
        @Step("Verify verifyLoginPassword: {0} step...")
        public void verifyLoginPassword (String expectedText) {
            Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedText);
        }
}
