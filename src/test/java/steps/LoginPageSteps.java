package steps;

import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {

	 private LoginPage loginPage;

	    public LoginPageSteps() {
	        this.loginPage = new LoginPage();
	    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials(String user, String pwd) {
        loginPage.enterEmail(user);
        loginPage.enterPassword(pwd);
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickLogin();
    }
}