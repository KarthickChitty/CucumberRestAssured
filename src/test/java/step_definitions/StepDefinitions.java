package step_definitions;

import org.junit.Assert;
import static io.restassured.RestAssured.given;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class StepDefinitions {
	String baseUri = "http://dummy.restapiexample.com";
	RequestSpecification _REQ_SPEC;
	Response _RESP_;
	ValidatableResponse _VAL_RESP_;
	
	@Given("I have employee base URI")
	public void i_have_employee_endpoint() {
		_REQ_SPEC  = given().baseUri(baseUri);
	}

	@When("I perfrom a {string} method on endpoint {string}")
	public void i_perfrom_a_method(String method, String empEndPoint) {
		_RESP_     = _REQ_SPEC.when().get(empEndPoint);
		System.out.println("_RESP_:" + _RESP_.asString());

	}

	@Then("I should be able to get response for {int} employee details")
	public void i_should_be_able_to_veiew_all_employee_details(Integer empCount) {
		_VAL_RESP_ = _RESP_.then();
		_VAL_RESP_.assertThat().body("data.id.size()", is(empCount));
	}

	@Then("I should be able to get response for {int} employee")
	public void i_should_be_able_to_get_response_for_employee(Integer empId) {
		_VAL_RESP_ = _RESP_.then();
		_VAL_RESP_.assertThat().body("data.id", equalTo(empId));
	}

	@Then("I should be able to verify employee name {string}")
	public void i_should_be_able_to_verify_employee_name(String employeeName) {
		_VAL_RESP_ = _RESP_.then();
		_VAL_RESP_.assertThat().body("data.employee_name", equalTo(employeeName));
	}
}
