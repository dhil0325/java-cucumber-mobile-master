package app.bersama.pages;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */
public class LoginPage {

    private AppiumDriver driver;

    public LoginPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/et_email")
    private WebElement emailField;

    @FindBy(id = "id.binar.fp.secondhand:id/et_password")
    private WebElement passwordField;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_login")
    private WebElement buttonMasuk;


    @FindBy(id = "id.binar.fp.secondhand:id/tv_register")
    private WebElement navLinkRegister;

    @FindBy(xpath = ".//*[contains(@text,'Email atau kata sandi salah')]")
    private WebElement toastError;

    public void Login(String email, String password) {
        Keyword.enterText(emailField, email);
        Keyword.enterText(passwordField, password);
        buttonMasuk.click();
    }

    public void navigateToRegister(){
        navLinkRegister.click();
    }

//    public void setToastError(){
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        wait.until(ExpectedConditions.presenceOfElementLocated('.//*[contains(@text,'Email atau kata sandi salah')])');
//
//
//    }
}
