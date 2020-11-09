package com.rest.RestUtility;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestResponse {
	
//	@Test
	public void testwithRoot(){
		given().
		get("https://reqres.in/api/users?page=1").
		then().root("data").body("id[0]", equalTo(1));
	}

	
//	@Test
	public void testExtractionDeatilsUsingPath(){
		String href = 
			when().
				get("https://reqres.in/api/users?page=1").
				then().contentType(ContentType.JSON).
				extract().path("avatar");
		System.out.println(href);
				
	}
	
	
	//@Test
	public void testExtractionDeatilsInOneLine(){
		String href = get("https://reqres.in/api/users?page=1").andReturn().jsonPath().getString("avatar");
		System.out.println(href);
		when().get(href).then().statusCode(200);
				
	}
	
	
		@Test
		public void verifyResponse(){
			Response response = 
					when().get("https://reqres.in/api/users?page=1").
					then().
					extract().response();
			System.out.println("Content Type"+response.contentType());
			System.out.println("Href "+response.path("avatar"));
			System.out.println("Status code"+response.statusCode());
					
		}
}
