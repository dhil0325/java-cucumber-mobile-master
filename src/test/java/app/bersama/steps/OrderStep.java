package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.DaftarJualPage;
import app.bersama.pages.InfoPenawarPage;
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

    @Given("user tap daftar jual saya")
    public void userTapDaftarJualSaya() {
        ProfilePage profilePage = new ProfilePage(DriverManager.getInstance().getDriver());
        profilePage.tapButtonDaftarJual();
    }

    @Given("user tap navigation list diminati and choose product want to accept")
    public void userTapNavigationListDiminatiAndChooseProductWantToAccept() {
        DaftarJualPage daftarJualPage = new DaftarJualPage(DriverManager.getInstance().getDriver());
        daftarJualPage.setNavigationDiminati();
    }


    @When("user tap button terima")
    public void userTapButtonTerima() {
        InfoPenawarPage infoPenawarPage = new InfoPenawarPage(DriverManager.getInstance().getDriver());
        infoPenawarPage.setAcceptProduct();
        
    }


    @Then("user see transaction frame {string}")
    public void userSeeTransactionFrame(String value) {
        new InfoPenawarPage(DriverManager.getInstance().getDriver()).
                setFrameDone(value);

    }
}
