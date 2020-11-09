package com.rest.RestUtility;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;

public class ResponseVerification {
	
	//@Test
	public void TestStatusInResponse(){
		given().
		get("https://jsonplaceholder.typicode.com/photos").then().assertThat().statusCode(200).log().all();
		get("https://jsonplaceholder.typicode.com/photos").then().assertThat().statusLine(containsString("OK"));
	}

	
	//@Test
	public void TestHeadersInResponse(){
		given().
		get("https://jsonplaceholder.typicode.com/photos").then().assertThat().header("X-header", "Express");
	
	}
	
	//@Test
	public void TestContentTypeInResponse(){
		given().
		get("https://jsonplaceholder.typicode.com/photos").then().assertThat().contentType(ContentType.JSON);
	
	}
	
	@Test
	public void TestBodyParametersinResponse(){
		given().
		get("https://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl", response -> equalTo("https://via.placeholder.com/150/92c952"));
	
	}
	
	
	

}
