package apitestrestassured.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue ={"classpath:step_definitions","classpath:hooks"},
		
		plugin = {"pretty", "html: test-output/cucumberreprot.html"
		},
				tags = "@employees"
				
		)
		

public class Runner {

}
