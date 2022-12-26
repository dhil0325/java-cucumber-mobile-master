package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.LoginPage;
import app.bersama.pages.MyAccountPage;
import app.bersama.pages.NavigationSectionPage;
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

    @When("user login with valid credential")
    public void user_login_with_valid_credential() {
        LoginPage loginPage = new LoginPage(
                DriverManager.getInstance().getDriver());
        loginPage.Login("lageming54@gmail.com", "fadhil45");
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

    }


}
