package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.After;
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

    @After
    public void tearDown() {
        closeBrowser();
    }
}
