package pages;

import org.openqa.selenium.By;

import framework.driver.DriverManager;
import framework.utils.WaitUtils;

public class LoginPage {

    private By emailInput = By.xpath("//input[@id='Email']");
    private By passwordInput = By.xpath("//input[@id='Password']");
    private By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public void enterEmail(String email) {
        WaitUtils.waitForVisible("//input[@id='Email']").sendKeys(email);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForVisible("//input[@id='Password']").sendKeys(password);
    }

    public void clickLogin() {
        System.out.println("Attempting to click the login button");
        WaitUtils.waitForClickable("//button[normalize-space()='Log in']").click();
    }
}
