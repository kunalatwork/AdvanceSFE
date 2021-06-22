package TestRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Rep.feature",
		glue = "RepStepDefination",
		dryRun = false,
		monochrome = true,
		plugin = {
				"html:Report/RepReport"
		}
		)
public class runnerClass {

}
