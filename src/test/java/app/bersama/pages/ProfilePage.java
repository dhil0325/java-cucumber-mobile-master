package app.bersama.pages;

import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProfilePage {
    private AppiumDriver driver;

    public ProfilePage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/seller")
    private WebElement daftarJualButton;

    @FindBy(id = "id.binar.fp.secondhand:id/order")
    private WebElement pesananSayaButton;

    @FindBy(id = "id.binar.fp.secondhand:id/logout")
    private WebElement logoutButton;

    @FindBy(id = "id.binar.fp.secondhand:id/iv_edit")
    private WebElement editAccountButton;

    public void verifyProfilePage(){
        Keyword.waitUntilElementIsVisible(editAccountButton);
    }
    public void tapButtonDaftarJual(){
        daftarJualButton.click();
    }
    public void setLogoutButton(){
        logoutButton.click();
    }
}
