package pages;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class OpenUrl  extends BasePage {
    //*********Constructor*********
    public OpenUrl (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    //String baseURL = "http://www.n11.com/";
   String baseURL = "http://www.preprod.cartier.com/";




  //  String signInButtonClass = "btnSignIn";

     String signInButtonClass = "x-link-white";
     String myAccountByxpath = "//*[@class='nav-link js-nav-link-connection']";




    //*********Page Methods*********

    //Go to Homepage
    @Step("Open N11 Step...")
    public void goToN11 () throws IOException, InterruptedException {
        driver.get(baseURL);

      // Runtime.getRuntime().exec("C:\\Program Files\\IntelliJ\\IntelliJ IDEA\\Nouveau dossier\\authentication.exe");
        sleep(2000);
       // driver.navigate().to(baseURL);
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public void goToLoginPage () throws IOException {
/*
        File src = new File("C:\\Users\\CDS_Admin\\IdeaProjects\\ExtentReportsExample-master\\ExtentReportsExample-master\\Dataset for Login.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet websites = wb.getSheet("websites");
        XSSFRow row = websites.getRow(1);
        int col_num= 0;
        int row_num =0;

        for(int i=0; i < row.getLastCellNum(); i++){
            if(row.getCell(i).getStringCellValue().trim().equals(country)){
                col_num = ++i;
                row_num = i;
            }
        }

        row= websites.getRow(col_num);
        XSSFCell cell = row.getCell(col_num);
        driver.get(String.valueOf(cell));
        Runtime.getRuntime().exec("C:\\Program Files\\IntelliJ\\IntelliJ IDEA\\Nouveau dossier\\authentication.exe");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click(By.className(signInButtonName));
    }
*/

      //  click(By.xpath(myAccountByxpath));
      //  driver.get(baseURL);
        driver.get("https://secure.www.preprod.cartier.de/de/services/my-cartier/RegistrationStep1.html");


    }  }

