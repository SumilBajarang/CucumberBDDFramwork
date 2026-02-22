package context;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;

public class TestContext {

    private final WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;

    public TestContext(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}
