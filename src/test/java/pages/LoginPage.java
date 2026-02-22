package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginMenuLink = By.xpath("//a[normalize-space()='Log in']");
    private final By emailTextbox = By.id("Email");
    private final By passwordTextbox = By.id("Password");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        click(loginMenuLink);
    }

    public void loginAs(String email, String password) {
        type(emailTextbox, email);
        type(passwordTextbox, password);
        click(loginButton);
    }
}
