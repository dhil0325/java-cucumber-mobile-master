package app.bersama.pages;

import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class InfoPenawarPage {

    private AppiumDriver driver;

    public InfoPenawarPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/rv_interested")
    private WebElement productDiminati;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_accept")
    private WebElement buttonAccept;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_reject")
    private WebElement buttonReject;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup")
    private WebElement frameDone;

    @FindBy(id = "id.binar.fp.secondhand:id/tv_bottom_sheet_title")
    private WebElement frameDoneText;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_contact")
    private WebElement buyerInfoButton;

    public void setAcceptProduct() {
        Keyword.waitUntilElementIsVisible(productDiminati);
        Keyword.waitUntilElementIsClickAble(buttonAccept);
        buttonAccept.click();
    }

    public void setFrameDone(String expectedMessage) {
        Keyword.waitUntilElementIsVisible(frameDone);
        Keyword.waitUntilElementIsClickAble(buyerInfoButton);
        Keyword.waitUntilElementIsVisible(frameDoneText);
        String actual = frameDoneText.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
