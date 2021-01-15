package hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	protected Scenario scn;
	
	@Before
	public void BeforeHook(Scenario scenario) {
		this.scn = scenario;
	}

	@After
	public void AfterHook() {
		scn.write("Scenario is completed with Status: " + scn.getStatus());
	}
	
}
