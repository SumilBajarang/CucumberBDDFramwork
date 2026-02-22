package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;

public class BaseSteps extends BaseClass {

    protected LoginPage loginPage;
    protected HomePage homePage;

    protected void launchApplication() {
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

    @After
    public void tearDown() {
        closeBrowser();
    }
}
