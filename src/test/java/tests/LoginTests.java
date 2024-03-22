package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class LoginTests extends TestBase {


    @Test
    public void LoginPositiveTest() {
        openLoginForm();
        fillLoginForm("retqa@mail.ru", "!123QWEasd");
        submitLoginForm();
        pause(3000);
       // Assert.assertTrue(isLoggedSuccess());
        clickOkButton();

    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}



