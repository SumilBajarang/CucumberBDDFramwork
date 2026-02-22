package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    private final By myAccountLink = By.xpath("//a[@class='ico-account']");
    private final By welcomeText = By.xpath("//h2[normalize-space()='Welcome to our store']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyAccountLinkDisplayed() {
        return driver.findElement(myAccountLink).isDisplayed();
    }

    public boolean isWelcomeTextDisplayed() {
        return driver.findElement(welcomeText).isDisplayed();
    }
}
