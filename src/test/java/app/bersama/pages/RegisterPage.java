package app.bersama.pages;

import app.bersama.Keyword;
import app.bersama.enums.Direction;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegisterPage {
    private AppiumDriver driver;

    public RegisterPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/et_name")
    private WebElement nameField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout" +
            "/android.widget.ScrollView[1]/android.view.ViewGroup/android.widget.LinearLayout[2]/" +
            "android.widget.FrameLayout/android.widget.EditText")
    private WebElement emailField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout" +
            "/android.widget.ScrollView[1]/android.view.ViewGroup/android.widget.LinearLayout[3]/" +
            "android.widget.FrameLayout/android.widget.EditText")
    private WebElement passwordField;

    @FindBy(id = "id.binar.fp.secondhand:id/et_phone")
    private WebElement numPhoneField;

    @FindBy(id = "id.binar.fp.secondhand:id/et_city")
    private WebElement cityField;

    @FindBy(id = "id.binar.fp.secondhand:id/et_address")
    private WebElement addressField;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_register")
    private WebElement registerButton;

    @FindBy(id = "id.binar.fp.secondhand:id/tv_login")
    private WebElement navLinkLogin;

    public void userRegister(String nama, String email,
                             String password, String phoneNum,
                             String city, String address) {
        Keyword.enterText(nameField, nama);
        Keyword.enterText(emailField, email);
        Keyword.enterText(passwordField, password);
        Keyword.enterText(numPhoneField, phoneNum);
        Keyword.enterText(cityField, city);
        Keyword.enterText(addressField, address);
        Keyword.swipe(Direction.UP);
        registerButton.click();
    }
}
