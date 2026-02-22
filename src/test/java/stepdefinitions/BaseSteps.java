package stepdefinitions;

import base.DriverFactory;
import context.TestContext;

public abstract class BaseSteps {

    protected TestContext context() {
        return Hooks.getContext();
    }

    protected String currentUrl() {
        return DriverFactory.getDriver().getCurrentUrl();
    }
}
