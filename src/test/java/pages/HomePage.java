package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By myAccountLink = By.xpath("//a[@class='ico-account']");
    private final By welcomeText = By.xpath("//h2[normalize-space()='Welcome to our store']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        return isDisplayed(myAccountLink);
    }

    public boolean isWelcomeTextDisplayed() {
        return isDisplayed(welcomeText);
    }
}
