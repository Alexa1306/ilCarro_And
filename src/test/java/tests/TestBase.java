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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
public class TestBase {
    static WebDriver wd;
    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }
@AfterMethod
    public void tearDown(){
        wd.quit();
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
public static void click(By locator){
        wd.findElement(locator).click();

}
public static void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);


}
public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;

}

        //assert


    static void submitLoginForm() {
click(By.xpath("//button[@type='submit']"));
    }

    static void fillLoginForm(String email, String password) {


type(By.id("email"), email) ;
type(By.id("password"), password);

    }

    static void openLoginForm() {
click(By.xpath("//*[.=' Log in ']"));

    }
    public boolean isLoggedSuccess(){
       return isElementPresent
               (By.xpath("//h2[contains(text(),'success')]"));

    }
    public void logout(){

        click(By.xpath("//*[.=' Logout ']"));
    }
public void clickOkButton(){

        click(By.xpath("//button[@type='button']"));
}

}
