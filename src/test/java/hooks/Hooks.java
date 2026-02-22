package hooks;

import org.openqa.selenium.WebDriver;
import framework.driver.DriverSetup;
import framework.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

	@BeforeAll
	public static void beforeAll() {
	    WebDriver driver = DriverSetup.createDriver();
	    DriverManager.setDriver(driver);
	}

	@Before
	public void beforeScenario() {
	    // reset state before each scenario if needed
	}

	@After
	public void afterScenario() {
	    // per-scenario cleanup, screenshots, etc.
	}

	@AfterAll
	public static void afterAll() {
	    WebDriver driver = DriverManager.getDriver();
	    if (driver != null) {
	        driver.quit();
	        DriverManager.unload();
	    }
	}
}