package base;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass {

    protected WebDriver driver() {
        return DriverFactory.getDriver();
    }
}
