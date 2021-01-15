package hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	protected Scenario scn;
	
	@Before
	public void BeforeHook(Scenario scenario) {
		this.scn = scenario;
	}

	@After
	public void AfterHook() {
		System.out.println("Scenario is completed with Status: " + scn.getStatus());
	}
	
}
