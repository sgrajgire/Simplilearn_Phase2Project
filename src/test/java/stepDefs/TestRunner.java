package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		plugin = {"html:target/html-cucmber", "json:target/cucumber.json"},
		features = "src/test/java/features",
		tags = {"@Feature_Login, @Feature_Products"},
		glue = {"stepDefs"}
		)
public class TestRunner {

}
