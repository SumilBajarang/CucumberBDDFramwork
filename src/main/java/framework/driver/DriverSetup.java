package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {

    private DriverSetup() {
        // Prevent object creation
    }

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        // Basic, stable options (you can add more later)
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}