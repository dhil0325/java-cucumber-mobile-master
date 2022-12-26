package app.bersama.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private AppiumDriver driver;

    public HomePage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id.binar.fp.secondhand:id/et_search")
    private WebElement searchField;

    @FindBy(id = "id.binar.fp.secondhand:id/iv_slider")
    private WebElement adsSlider;

    @FindBy(id = "id.binar.fp.secondhand:id/cv_category")
    private WebElement allCategory;
}
