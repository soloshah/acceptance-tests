package uk.nhs.nhsbsa.ccchs.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "pretty", "html:target/cucumber",
		"json:target/jsonReports/cucumber.json" }, features = "classpath:", dryRun = true, tags = {
				"@smoke" })

public class RunCukeTest
{
}
