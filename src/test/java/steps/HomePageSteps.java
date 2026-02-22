package steps;

import org.testng.Assert;

import framework.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {
	private HomePage homePage;
	
	public HomePageSteps() {
		homePage=new HomePage();
	}

    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage() {
        DriverManager.getDriver().get("https://demo.nopcommerce.com/");
        homePage.clickLoginLink();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        Assert.assertTrue(homePage.isMyAccountVisible(), "My Account link is not visible");
    }

    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        Assert.assertTrue(homePage.isWelcomeMessageVisible(), "Welcome message is not visible");
    }
}