package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.LoginPage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {
    @Given("user navigate to register page")
    public void userNavigateToRegisterPage() {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.navigateToRegister();
    }


    @When("user fill out register form and tap register")
    public void userFillOutRegisterFormAndTapRegister() {
        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.userRegister("Fadhil", "fadhil6753@gmail.com",
                "password123","085654623216",
                "Jakarta", "Jakarta Pusat");

    }

    @Then("user should be navigate to profile page")
    public void userShouldBeNavigateToProfilePage() {
    }
}
