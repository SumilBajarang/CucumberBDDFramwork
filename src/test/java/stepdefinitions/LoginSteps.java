package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage() {
        context().getLoginPage().openLoginForm();
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void theUserEntersValidCredentials(String user, String pwd) {
        context().getLoginPage().loginAs(user, pwd);
    }

    @Then("the user should be redirected to the My Account page")
    public void theUserShouldBeRedirectedToTheMyAccountPage() {
        Assert.assertTrue(context().getHomePage().isMyAccountLinkDisplayed(),
                "My account link is not displayed after login. Current URL: " + currentUrl());
    }

    @Then("the user should see a welcome message")
    public void theUserShouldSeeAWelcomeMessage() {
        Assert.assertTrue(context().getHomePage().isWelcomeTextDisplayed(), "Welcome message is not displayed.");
    }
}
