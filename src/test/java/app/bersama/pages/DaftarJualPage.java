package app.bersama.pages;

import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DaftarJualPage {
    private AppiumDriver driver;

    public DaftarJualPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Produk\"]/android.widget.TextView")
    private WebElement navigationProduct;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Diminati\"]/android.widget.TextView")
    private WebElement navigationDiminati;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Terjual\"]/android.widget.TextView")
    private WebElement navigationTerjual;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
            "android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/" +
            "androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/" +
            "androidx.cardview.widget.CardView/android.view.ViewGroup")
    private WebElement productDisplay;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_delete")
    private WebElement productDelleteButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private WebElement diminatiProductDisplay;

    public void setNavigationDiminati() {
        navigationDiminati.click();
        Keyword.waitUntilElementIsClickAble(diminatiProductDisplay);
        diminatiProductDisplay.click();
    }
}
