package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import restassuredwrap.RestAssuredWrap;

import java.io.File;

import hooks.Props;

public class RippleAppStepDefinitions {
	

	static Props properties = new Props();
	/*
	 * @Value("${baseuri}") static String baseUri;
	 * 
	 * @Value("${rippleIndexEndPoint}") static String index;
	 * 
	 * @Value("${rippleLogoutEndpoint}") static String logoutEndpoint;
	 * 
	 * @Value("$creatUserJson}") static String createUserFilePath;
	 */
	
	
	 static String baseUri = properties.fetchBaseURI();
	 static String index = properties.fetchEndpoint("index");
	 static String logoutEndpoint = properties.fetchEndpoint("logout");
	 String createUserFilePath = properties.fetchcreateuserjsonpath();
		
	File jsonDataInFile = new File(createUserFilePath);
	RestAssuredWrap restAssured = new RestAssuredWrap();
	
	@Given("rippleapp scope session is up and running")
	public void rippleapp_scope_session_is_up_and_running() {
		restAssured.initBaseUriSession(baseUri);
		restAssured.getMethod(index);
		restAssured.assertStatuCode(200);
	}

	@Given("rippleapp index is up and running")
	public void rippleapp_index_is_up_and_running() {
		restAssured.initBaseUriSession(baseUri);
		restAssured.getMethod(index);
		restAssured.assertStatuCode(200);
	}

	@When("I logout from the session")
	public void i_logout_from_the_session() {
		restAssured.getMethod(logoutEndpoint);
		restAssured.assertStatuCode(200);
	}

	@When("I perfrom a {string} method on endpoint {string}")
	public void i_perfrom_a_method(String method, String endPoint) {
		endPoint = properties.fetchEndpoint(endPoint);
		switch(method)
		{
			case "GET":
				restAssured.getMethod(endPoint);
				restAssured.assertStatuCode(200);
				break;
			case "POST":
				restAssured.postMethod(jsonDataInFile, endPoint, ContentType.JSON);
				break;
			default:
		}
		
	}
	
	@Then("I should see new user got added")
	public void i_should_see_new_user_got_added() {
		restAssured.assertStatuCode(201);
	}
	

	@Then("I should see session current message {string}")
	public void i_should_see_session_current_message(String currentMsg) {
		restAssured.assertBodyMsg("currentMessage",currentMsg);
	}
	
	@Then("I should see session previous message {string}")
	public void i_should_see_session_previous_message(String preMsg) {
		if(preMsg.contains("null"))
			preMsg=null;
		restAssured.assertBodyMsg("previousMessage",preMsg);
	}
	
	@Then("I should see new user as part of response")
	public void i_should_see_new_user_as_part_of_response() {
		restAssured.assertBodyContains(jsonDataInFile);
	}
	


	
}
