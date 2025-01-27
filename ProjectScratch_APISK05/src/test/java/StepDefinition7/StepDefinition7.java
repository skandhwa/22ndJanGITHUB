package StepDefinition7;

import Utilities.FetchDatafromExcel;
import Utilities.FetchDatafromProperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import POJOMapper.CreateUser;
import PayloadData.TestData;

public class StepDefinition7 {
	
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	Response response;
	
	String URL=FetchDatafromProperty.readDataFromProperty().getProperty("URL1");
	String authToken=FetchDatafromProperty.readDataFromProperty().getProperty("token");
	
	

	@Given("user has requested to hit an application URL")
	public void user_has_requested_to_hit_an_application_url() {
		
		req=new RequestSpecBuilder().setBaseUri(URL).setContentType(ContentType.JSON)
				.build();
	    
	}

	@Given("user will pass the payload with all needed details")
	public void user_will_pass_the_payload_with_all_needed_details() throws InvalidPathException, IOException {
		
		res=given().log().all().relaxedHTTPSValidation().spec(req)
				.body(CreateUser.userDetais());
		
	//	res=given().log().all().relaxedHTTPSValidation().spec(req)
	//			.body(FetchDatafromExcel.AddNewUserDetails());
		
	   
	}

	@When("user will hit the specific {string}")
	public void user_will_hit_the_specific(String endpoint) {
		
		respec=new ResponseSpecBuilder().build();
		response=res.when().post(endpoint).then().log().all().spec(respec)
				.extract().response();
		
	    
	}

	@Then("we are going to validate the status code as specific {string}")
	public void we_are_going_to_validate_the_status_code_as_specific(String status_code) throws JsonMappingException, JsonProcessingException {
	    
		long time=response.getTime();
		
		if(time<5000)
		{
			System.out.println("It is within threshold");
		}
		else
		{
			throw new ArithmeticException();
		}
		
		String s=status_code;
		int expectedStatusCode=Integer.parseInt(s);
		
		int actualStatusCode=response.getStatusCode();
		
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
		
		
		JsonPath js=new JsonPath(response.asString());
		
		
	String ActualName=	js.getString("name");
	
	String ExpectedName=CreateUser.getName();
	Assert.assertEquals(ActualName, ExpectedName);
	
		
		
	}
	
	
	
	@Given("user passes a payload with all required credentials")
	public void user_passes_a_payload_with_all_required_credentials() {
		
		res=given().log().all().headers("Authorization",authToken).
				relaxedHTTPSValidation().spec(req)
				.body(TestData.AddUserDetails());
		
	    
	}

	@When("the user is going to hit url with {string}")
	public void the_user_is_going_to_hit_url_with(String endpoint1) {
		
		respec=new ResponseSpecBuilder().build();
		response=res.when().post(endpoint1).then().log().all().spec(respec)
				.extract().response();
	    
	}

	@Then("user will be able to validate the response code and the body")
	public void user_will_be_able_to_validate_the_response_code_and_the_body() {
		
long time=response.getTime();
		
		if(time<50000)
		{
			System.out.println("It is within threshold");
		}
		else
		{
			throw new ArithmeticException();
		}
		String status_code="201";
		String s=status_code;
		int expectedStatusCode=Integer.parseInt(s);
		
		int actualStatusCode=response.getStatusCode();
		
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
//		
//		JsonPath js=new JsonPath(response.asString());
//	String Expected_name=	js.getString("name");
//	Object ActualName=TestData.getName();
//	String ActName=ActualName.toString();
//	
//	Assert.assertEquals(ActName, Expected_name);
//	//System.out.println("Test Case passed");
//	
//	
//	String Expected_email=	js.getString("email");
//	Object Actualemail=TestData.getEmail();
//	String Actemail=Actualemail.toString();
//	System.out.println(Actemail);
//	System.out.println(Expected_email);
//	
//	
//	Assert.assertEquals(Actemail, Expected_email);
//	System.out.println("Test Case passed");
		
		
		
		
		
		
	   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
