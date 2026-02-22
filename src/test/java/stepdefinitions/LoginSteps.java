package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage() {
        if (driver == null) {
            launchApplication();
        }
        loginPage.clickLoginMenu();
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void theUserEntersValidCredentials(String user, String pwd) {
        loginPage.enterEmail(user);
        loginPage.enterPassword(pwd);
    }

    @When("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the My Account page")
    public void theUserShouldBeRedirectedToTheMyAccountPage() {
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed(), "My account link is not displayed after login.");
    }

    @Then("the user should see a welcome message")
    public void theUserShouldSeeAWelcomeMessage() {
        Assert.assertTrue(homePage.isWelcomeTextDisplayed(), "Welcome message is not displayed.");
    }
}
