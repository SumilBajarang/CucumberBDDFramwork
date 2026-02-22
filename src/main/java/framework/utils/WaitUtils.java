package framework.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.driver.DriverManager;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10; // seconds

    private static WebDriverWait getWait(int timeoutInSeconds) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
    }

    private static WebDriverWait getWait() {
        return getWait(DEFAULT_TIMEOUT);
    }

    // Wait until element is visible
    public static WebElement waitForVisible(String xpath) {
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
        );
    }

    // Wait until element is clickable
    public static WebElement waitForClickable(String xpath) {
        return getWait().until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
        );
    }

    // Wait until element is present in DOM
    public static WebElement waitForPresence(String xpath) {
        return getWait().until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))
        );
    }

    // Wait until element disappears
    public static boolean waitForInvisibility(String xpath) {
        return getWait().until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath))
        );
    }

    // Custom timeout versions

    public static WebElement waitForVisible(String xpath, int timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
        );
    }

    public static WebElement waitForClickable(String xpath, int timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
        );
    }
}