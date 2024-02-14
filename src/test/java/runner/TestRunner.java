package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * Test runner class which will be used to trigger test Automation features
 */

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src\\test\\java\\features",

		glue = { "stepDefinitions" }, plugin = { "pretty", "html:target/cucumber-reports" }

)

public class TestRunner {

}