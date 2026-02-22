package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By loginMenuLink = By.xpath("//a[normalize-space()='Log in']");
    private final By emailTextbox = By.id("Email");
    private final By passwordTextbox = By.id("Password");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginMenu() {
        driver.findElement(loginMenuLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailTextbox).clear();
        driver.findElement(emailTextbox).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
