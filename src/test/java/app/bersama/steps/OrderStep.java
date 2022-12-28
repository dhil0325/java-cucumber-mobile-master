package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.ProductPage;
import app.bersama.pages.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderStep {
    @Given("tap button saya tertarik dan ingin nego")
    public void tapButtonSayaTertarikDanInginNego() {
        ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
        productPage.setBidPriceButton();
    }

    @When("fill out bid price and tap button kirim")
    public void fillOutBidPriceAndTapButtonKirim() {
        ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
        productPage.setBidPrice("500000");
    }

    @Then("see notification {string}")
    public void seeNotification(String value) {
        new ProductPage(DriverManager.getInstance().getDriver()).
                bidNotification(value);

    }

}
