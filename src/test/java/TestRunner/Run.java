package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		
		//features = {".//Features/LoginFeature.feature",".//Features/Customers.feature"},
		features = ".//Features",
		glue="StepDefinition",
		monochrome = true,
		tags = "@Smoke",
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)

public class Run extends AbstractTestNGCucumberTests{
}
