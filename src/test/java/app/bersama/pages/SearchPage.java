package app.bersama.pages;

import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    private AppiumDriver driver;

    public SearchPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[2]/" +
            "android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.EditText")
    private WebElement searchField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
            "android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private WebElement productSearch;

    public void inputSearch(String productName) {
        searchField.sendKeys(productName);
    }
    public void tapProductSearch(){
        Keyword.waitUntilElementIsClickAble(productSearch);
        productSearch.click();
    }
}
