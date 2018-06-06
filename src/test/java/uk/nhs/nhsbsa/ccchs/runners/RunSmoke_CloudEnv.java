package uk.nhs.nhsbsa.ccchs.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import gherkin.formatter.AnsiFormats;

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        //plugin =  {"pretty", "html:target/cucumber","json:target/jsonReports/ExampleTest.json"},
        format =  {"pretty", "html:target/cucumber","json:target/jsonReports/ExampleTest.json"},
        glue = {"org.cucumber"},
        features = {"src/test/resources/features/Cloud/"},
        tags ={"@smoke"}
)

public class RunSmoke_CloudEnv {

}



/* 
 * 
 * mvn verify -Dcucumber.options="src/test/resources/features/Cloud --tags @smoke --no-dry-run"
 * 
 * */
 