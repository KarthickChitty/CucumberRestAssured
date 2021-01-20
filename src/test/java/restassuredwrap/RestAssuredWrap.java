package restassuredwrap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;

import hooks.Hooks;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredWrap {
	
	static RequestSpecification reqSpec;
	static Response resp;
	static ValidatableResponse valResp;
	Hooks hook = new Hooks();
	SessionFilter sessionFilter = new SessionFilter();

	public void initBaseUriSession(String baseURI) {
		reqSpec = given()
				.filter(sessionFilter)
				.baseUri(baseURI);
	}
	public void getMethod(String getEndpoint) {
		try {
			resp = reqSpec
					.get(getEndpoint);
			valResp = resp.then();
			hook.scenario.log("getMethod worked for endpoint: " + getEndpoint);
		}catch(Exception ex) {
			hook.scenario.log("getMethod not worked for endpoint: " + getEndpoint);
		}
	}
	
	public void assertStatuCode(int statusCode) {
		valResp.assertThat().statusCode(statusCode);
		hook.scenario.log("Response Status code for: " + statusCode + " validated");
	}
	public void postMethod(File jsonDataInFile, String endPoint, ContentType json) {
		resp = reqSpec
				.contentType(ContentType.JSON)
				.body(jsonDataInFile)
				.post(endPoint);
		valResp = resp.then();
		hook.scenario.log("Post operation performed..");
	}
	
	public void assertBodyMsg(String key, String value) {
		valResp.assertThat().body(key, equalTo(value)); 
		hook.scenario.log("Expected value " + value + " for key " + key + " found");
	}

	public void assertBodyContains(File jsonDataInFile) {
		int index = resp.body().jsonPath().get("size()");
		String lastIndex = String.valueOf(index-1);
		String createdUser = resp.body().jsonPath().get("["+lastIndex+"]").toString();

		String value = "Karthick";
		valResp.assertThat().body("["+lastIndex+"].firstName", equalTo(value));
		
		hook.scenario.log("respBody Created User: " + createdUser);
		
	}

}
