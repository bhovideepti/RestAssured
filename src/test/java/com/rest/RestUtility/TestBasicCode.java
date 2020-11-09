package com.rest.RestUtility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class TestBasicCode {
	
	//@Test
	public void testStatusCode(){
		given().
		get("https://reqres.in/api/users?page=1").
		then().
		statusCode(200);
	}
	
	//@Test
	public void testLogging(){
		given().
		get("https://reqres.in/api/users?page=1").
		then().statusCode(200).log().all();
	}

	
	//@Test
	public void testBodyEqual(){
		given().
		get("https://reqres.in/api/users?page=1").
		then().body("data.first_name[0]", equalTo("George"));
	}
	
	/**
	 * Method to check items in json
	 */
	@Test
	public void testBody(){
		given().
		get("https://reqres.in/api/users?page=1").
		then().body("data.first_name", hasItems("George","Janet","Emma"));
	}
	
	
	@Test
	public void testParametersandHeaders(){
		given().param("key1", "value1").header("head1","value1").
		when().
		get("https://reqres.in/api/users?page=1").
		then().statusCode(200);
	}


	

}
