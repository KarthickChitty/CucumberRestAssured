package apitestrestassured.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue ={"classpath:step_definitions","classpath:hooks"},
		
		plugin = {"pretty",
				"html: test-output/cucumberreprot"
		},
				tags = "@employees"
				
		)
		

public class Runner {

}
