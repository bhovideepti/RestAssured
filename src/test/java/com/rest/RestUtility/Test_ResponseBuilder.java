package com.rest.RestUtility;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;

public class Test_ResponseBuilder {
	
	//@Test
	public void TestStatusInResponse(){
		given().
		get("https://jsonplaceholder.typicode.com/photos").then().assertThat().statusCode(200).log().all();
		get("https://jsonplaceholder.typicode.com/photos").then().assertThat().statusLine(containsString("OK"));
	}

	
}
