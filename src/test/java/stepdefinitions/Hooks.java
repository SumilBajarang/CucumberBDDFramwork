package stepdefinitions;

import base.DriverFactory;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {

    private static final ThreadLocal<TestContext> CONTEXT = new ThreadLocal<>();

    @Before
    public void setUp() {
        DriverFactory.initializeDriver(ConfigReader.isHeadless());
        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
        CONTEXT.set(new TestContext(DriverFactory.getDriver()));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        CONTEXT.remove();
    }

    public static TestContext getContext() {
        TestContext context = CONTEXT.get();
        if (context == null) {
            throw new IllegalStateException("Test context is not initialized.");
        }
        return context;
    }
}
