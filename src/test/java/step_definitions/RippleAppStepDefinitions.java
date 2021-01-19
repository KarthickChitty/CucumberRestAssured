package step_definitions;

import static io.restassured.RestAssured.given;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.session.SessionFilter;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RippleAppStepDefinitions {
	static String baseUri = "http://localhost:8083";
	static RequestSpecification reqSpec;
	static Response resp;
	static Response resptemp;
	static ValidatableResponse valResp;
	static String sessionId = "";
	Headers headers = new Headers();
	SessionFilter sessionFilter = new SessionFilter();
	File jsonDataInFile = new File("src/test/resources/Payloads/createUser.json");
	
	void initBaseUri() {
		reqSpec = given()
				.filter(sessionFilter)
				.baseUri(baseUri);
	}

	@Given("rippleapp scope session is up and running")
	public void rippleapp_scope_session_is_up_and_running() {
		initBaseUri();
		resp = reqSpec.when().get("/ripple/index");
		valResp = resp.then();
		valResp.assertThat().statusCode(200);
	}


	@Given("rippleapp index is up and running")
	public void rippleapp_index_is_up_and_running() {
		initBaseUri();
		resp = reqSpec.when().get("/ripple/index");
		valResp = resp.then();
		valResp.assertThat().statusCode(200);
	}

	@When("I logout from the session")
	public void i_logout_from_the_session() {
		resp = reqSpec
				.get("/ripple/logout/session");
		resp.then().assertThat().statusCode(200);
	}

	@When("I perfrom a {string} method on endpoint {string}")
	public void i_perfrom_a_method(String method, String endPoint) {
		switch(method)
		{
			case "GET":
				resp = reqSpec
					.get(endPoint);
				resp.then().assertThat().statusCode(200);
				System.out.println("GET Method: " + resp.getBody().asString());
				valResp = resp.then();
				break;
			case "POST":
				resp = reqSpec
					.contentType(ContentType.JSON)
					.body(jsonDataInFile)
					.post(endPoint);
				System.out.println("GET Method: " + resp.getBody().asString());
				valResp = resp.then();
				break;
			default:
		}
		
	}
	
	@Then("I should see new user got added")
	public void i_should_see_new_user_got_added() {
		valResp.assertThat().statusCode(201);
	}
	

	@Then("I should see session current message {string}")
	public void i_should_see_session_current_message(String currentMsg) {
		valResp.assertThat().body("currentMessage", equalTo(currentMsg)); 
		System.out.println("CurrentMsg: " + resp.getBody().asString());
	}
	
	@Then("I should see session previous message {string}")
	public void i_should_see_session_previous_message(String preMsg) {
		if(preMsg.contains("null"))
			preMsg=null;
		valResp.assertThat().body("previousMessage", equalTo(preMsg));
		System.out.println("previousMsg: " + resp.getBody().asString());
		
	}
	


	
}
