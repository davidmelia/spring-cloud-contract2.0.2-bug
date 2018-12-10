package uk.gw;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/update", plugin = {"pretty", "html:target/cucumber"}, strict = true)
public class UpdateTest {

}
