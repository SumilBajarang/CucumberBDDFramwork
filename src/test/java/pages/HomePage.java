package pages;

import framework.utils.WaitUtils;

public class HomePage {

    private String myAccountLink = "//a[@class='ico-account']";
    private String welcomeText = "//h2[normalize-space()='Welcome to our store']";
    private String loginLink = "//a[normalize-space()='Log in']";

    public void clickLoginLink() {
        WaitUtils.waitForClickable(loginLink).click();
    }

    public boolean isMyAccountVisible() {
        return WaitUtils.waitForVisible(myAccountLink).isDisplayed();
    }

    public boolean isWelcomeMessageVisible() {
        return WaitUtils.waitForVisible(welcomeText).isDisplayed();
    }
}