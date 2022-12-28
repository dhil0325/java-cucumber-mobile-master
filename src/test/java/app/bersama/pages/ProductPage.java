package app.bersama.pages;

import app.bersama.Keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    private AppiumDriver driver;

    public ProductPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
            "android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/" +
            "android.widget.ImageView")
    private WebElement productImage;

    @FindBy(id = "id.binar.fp.secondhand:id/et_product_bid_price")
    private WebElement bidPriceField;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_bid")
    private WebElement setButtonTertarik;

    @FindBy(id = "id.binar.fp.secondhand:id/btn_bid")
    private WebElement bidPriceButton;

    @FindBy(id = "id.binar.fp.secondhand:id/design_bottom_sheet")
    private WebElement frameBid;

    @FindBy(id = "id.binar.fp.secondhand:id/tv_message")
    private WebElement messageText;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout[2]/androidx.cardview.widget.CardView/android.view.ViewGroup")
    private WebElement notificationBox;


    public void verifyProductPage() {
        Keyword.waitUntilElementIsVisible(productImage);
    }

    public void setBidPriceButton() {
        setButtonTertarik.click();
    }

    public void setBidPrice (String price) {
        Keyword.waitUntilElementIsVisible(frameBid);
        bidPriceField.sendKeys(price);
        Keyword.waitUntilElementIsClickAble(bidPriceButton);
        bidPriceButton.click();
    }


    public void bidNotification(String expectedMessage) {
        Keyword.waitUntilElementIsVisible(notificationBox);
        String actual = messageText.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
