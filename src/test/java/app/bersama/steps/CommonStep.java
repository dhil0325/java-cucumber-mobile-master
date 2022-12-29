package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author regiewby on 22/12/22
 * @project java-cucumber-mobile
 */
public class CommonStep {
    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {
        NavigationSectionPage navigationSectionPage = new NavigationSectionPage(
                DriverManager.getInstance().getDriver());

        MyAccountPage myAccountPage = new MyAccountPage(
                DriverManager.getInstance().getDriver());

        navigationSectionPage.tapNavigationAccount();
        myAccountPage.tapButtonLogin();
    }

    @When("user login with {string}")
    public void userLoginWith(String credentialType) {
        String email = "";
        String password = "";
        switch (credentialType) {
            case "valid_credential1":
                email = "lageming54@gmail.com";
                password = "fadhil45";
                break;

            case "valid_credential2":
                email = "frozt.fadhil@gmail.com";
                password = "fadhil45";
                break;

            case "valid_credential3":
                email = "fadhil2309@gmail.com";
                password = "fadhil45";
                break;

            case "invalid_credential":
                email = "lageming54@gmail.com";
                password = "asdasdsadsa";
                break;
        }
        LoginPage loginPage = new LoginPage(
                DriverManager.getInstance().getDriver());
        loginPage.Login(email, password);
    }

    @Then("user should be directed to profilepage")
    public void userShouldBeDirectedToProfilepage() {
        ProfilePage profilePage = new ProfilePage(DriverManager.getInstance().getDriver());
        profilePage.verifyProfilePage();
    }

    @Given("navigate to homepage and tap search field")
    public void navigateToHomepageAndTapSearchField() {
        NavigationSectionPage navigationSectionPage = new NavigationSectionPage(DriverManager.
                getInstance().getDriver());
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        navigationSectionPage.tapButtonHome();
        homePage.setSearchField();
    }

    @When("input product search and click product")
    public void inputProductSearchAndClickProduct() {
        SearchPage searchPage = new SearchPage(DriverManager.getInstance().getDriver());
        searchPage.inputSearch("Akun RF Dewa");
        searchPage.tapProductSearch();
    }

    @Then("navigate to product page")
    public void navigateToProductPage() {
        ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
        productPage.verifyProductPage();
    }

    @Given("user navigate to homepage")
    public void userNavigateToHomepage() {
        NavigationSectionPage navigationSectionPage = new NavigationSectionPage(DriverManager.getInstance().getDriver());
        navigationSectionPage.tapButtonHome();
    }

    @When("user tap logout button")
    public void userTapLogoutButton() {
        ProfilePage profilePage = new ProfilePage(DriverManager.getInstance().getDriver());
        profilePage.setLogoutButton();
    }
}
