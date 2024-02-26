package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.Response.LoginResponse;
import resources.APIResources;
import resources.BuildRequest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class stepDefinitions {
	
	BuildRequest buildRequest = new BuildRequest();
	RequestSpecification requestspecification;
	Response response;
	LoginResponse loginResponse;
		
	@Given("payload for login api with credentials {string} and {string}")
	public void payload_for_login_api_with_credentials_and(String userEmail, String userPassword) {
		requestspecification = given().baseUri("https://rahulshettyacademy.com/").contentType(ContentType.JSON).body(buildRequest.loginRequestStructure(userEmail, userPassword));
	}
	
	@When("user calls {string} with {string} request")
	public void user_calls_with_request(String resource, String httpMethod) {
		APIResources apiResource = APIResources.valueOf(resource);
		if(httpMethod.equalsIgnoreCase("post")) {
			response = requestspecification.when().post(apiResource.getResource()).then().extract().response();
		}
		if(httpMethod.equalsIgnoreCase("get")) {
			response = requestspecification.when().get(apiResource.getResource()).then().extract().response();
		}	    
	}
	
	@Then("validate that the status code is {int}")
	public void validate_that_the_status_code_is(int statusCode) {
		assertEquals(response.getStatusCode(),statusCode);
	    
	}
	@Then("validate that the {string} is {string}")
	public void validate_that_the_is(String headerParameter, String headerValue) {
		if(headerParameter.contains("Content-Type")) {
			assert(response.getContentType().contains(headerValue));
		}	    
	}
	@Then("validate the message {string} is passed in the response body")
	public void validate_the_message_is_passed_in_the_response_body(String message) {
		loginResponse = response.as(LoginResponse.class);
		assert(loginResponse.getMessage().contains(message));
	}

}
