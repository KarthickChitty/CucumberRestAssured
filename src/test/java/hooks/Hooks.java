package hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	static public Scenario scenario;
	
	@Before
	public void BeforeHook(Scenario scenario) {
		this.scenario = scenario;
	}
	

	@After
	public void AfterHook() {
//		System.out.println("Scenario is completed with Status: " + scn.getStatus());
	}
	

	
}
