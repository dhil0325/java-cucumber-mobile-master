package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.LoginPage;
import app.bersama.pages.ProfilePage;
import app.bersama.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class RegisterStep {
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    @Given("user navigate to register page")
    public void userNavigateToRegisterPage() {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.navigateToRegister();
    }

    @When("user fill out register form and tap register")
    public void userFillOutRegisterFormAndTapRegister() {
        RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
        registerPage.userRegister("Fadhil", getSaltString()+"@gmail.com",
                "password123","085654623216",
                "Jakarta", "Jakarta Pusat");

    }

    @Then("user should be navigate to profile page")
    public void userShouldBeNavigateToProfilePage() {
        ProfilePage profilePage = new ProfilePage(DriverManager.getInstance().getDriver());
        profilePage.verifyProfilePage();
    }
}
