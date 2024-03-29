package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.google.common.io.Files;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {

	@Before
	public void setup1() {
		log = LogManager.getLogger("StepDef");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPg = new SearchCustomerPage(driver);
		log.info("Browser launched");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);

	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
	}

	////////// Login feature///////////////////////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception ex) {

		}

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLogOutButton();

	}

	/*
	 * @Then("close browser") public void close_browser() { driver.close();
	 * log.info("Browser closed");
	 * 
	 * //driver.quit(); }
	 */

	/////////////////////////// Add new customer/////////////////////

	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		hardWait(3);
		addNewCustPg.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		hardWait(3);
		addNewCustPg.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);// fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1988");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(exptectedConfirmationMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}

	}

	//////////// Search Customer//////////////////////////
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		// Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if (SearchCustPg.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}

	}

	/////////////// search customer by name////////////////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		SearchCustPg.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		SearchCustPg.enterLastName("Terces");

	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";

		if (SearchCustPg.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}

	@After
	public void teardown(Scenario sc) {
		System.out.println("Tear Down method executed..");
		//if (sc.isFailed() == true) {
			// Convert web driver object to TakeScreenshot
		    String timeStamp = new SimpleDateFormat("dd-MM-yyyy__HH-mm-ss").format(new Date());
		    log.info(timeStamp);
			String fileWithPath = "C:\\AAA_LEARNING\\CucumberBDDFramwork\\screenshots\\screenshot_"+timeStamp+".png";
			log.info(fileWithPath);
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			// Copy file at destination
			try {
				//FileUtils.copyFile(SrcFile, DestFile);
				Files.copy(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//} else
			//driver.quit();
	}
}
