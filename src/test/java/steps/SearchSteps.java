package steps;

import org.testng.Assert;

import framework.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage;

    public SearchSteps() {
        this.searchPage = new SearchPage();
    }

    @Given("the user is on the nopCommerce home page")
    public void the_user_is_on_the_nopcommerce_home_page() {
        DriverManager.getDriver().get("https://demo.nopcommerce.com/");
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String keyword) {
        searchPage.enterSearchTerm(keyword);
        searchPage.clickSearchButton();
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        int count = searchPage.getSearchResultCount();
        Assert.assertTrue(count > 0, "Expected search results, but found none.");
    }

    @Then("no search results message should be displayed")
    public void no_search_results_message_should_be_displayed() {
        Assert.assertTrue(searchPage.isNoResultMessageDisplayed(), "No results message was not displayed.");
    }
}