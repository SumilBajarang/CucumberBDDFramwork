package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.driver.DriverManager;
import framework.utils.WaitUtils;

public class SearchPage {

    // Locators
    private String searchBox = "//input[@id='small-searchterms']";
    private String searchButton = "//button[@type='submit' and contains(@class,'search-box-button')]";
    private By productItems = By.cssSelector(".product-item");
    private String noResultText = "//div[contains(@class,'no-result')]";

    public SearchPage() {
        // Constructor for future use
    }

    public void enterSearchTerm(String term) {
        WaitUtils.waitForVisible(searchBox).clear();
        WaitUtils.waitForVisible(searchBox).sendKeys(term);
    }

    public void clickSearchButton() {
        WaitUtils.waitForClickable(searchButton).click();
    }

    public int getSearchResultCount() {
        List<WebElement> results = DriverManager.getDriver().findElements(productItems);
        return results.size();
    }

    public boolean isNoResultMessageDisplayed() {
        try {
            return WaitUtils.waitForVisible(noResultText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}