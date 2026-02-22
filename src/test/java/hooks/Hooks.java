package hooks;

import org.openqa.selenium.WebDriver;
import framework.driver.DriverSetup;
import framework.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println(">>> HOOKS @Before is running <<<");

        WebDriver driver = DriverSetup.createDriver();
        System.out.println(">>> Driver created: " + driver);

        DriverManager.setDriver(driver);
        System.out.println(">>> Driver set in DriverManager <<<");
    }

    @After
    public void tearDown() {
        System.out.println(">>> HOOKS @After is running <<<");

        WebDriver driver = DriverManager.getDriver();
        System.out.println(">>> Driver from DriverManager in @After: " + driver);

        if (driver != null) {
            driver.quit();
            DriverManager.unload();
        }
    }
}