package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseClass {

    private LoginPage loginPage;
    private HomePage homePage;

    private void launchApplication() {
        initializeDriver();
        openApplication("https://demo.nopcommerce.com/");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("the user initializes browser")
    @Given("uuser initializes browser")
    public void theUserInitializesBrowser() {
        launchApplication();
    }

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

    @After
    public void tearDown() {
        closeBrowser();
    }
}
