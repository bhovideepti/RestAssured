package com.rest.RestUtility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class TestRequestData {
	
	//@Test
	public void testConnect(){
		when().request("CONNECT", "https://jsonplaceholder.typicode.com/photos").then().statusCode(200);
	}

	
	//@Test
	public void testQueryParameters(){
		given().
		queryParam("A","a val").
		queryParam("B","b val").
		when().get("https://jsonplaceholder.typicode.com/photos").
		then().statusCode(200);
	}
	
	//@Test
	public void testPostQuery(){
		given().
		formParam("A","a val").
		formParam("B","b val").
		when().post("https://jsonplaceholder.typicode.com/photos").
		then().statusCode(200);
	}
	
	
	//@Test
	public void testSetPathParam(){
		given().
		pathParam("ph","photos").
		when().post("https://jsonplaceholder.typicode.com/{ph}").
		then().statusCode(200);
	}
	
	//@Test
	public void testSetHeaders(){
		given().
	    header("K", "V").
	    header("K", "V1","V2").
	    headers("User","MyApp","Charset","UTF-8").
		when().post("https://jsonplaceholder.typicode.com/photos").
		then().statusCode(200);
	}
	
	@Test
	public void testSetContentType(){
		given().
	    header("K", "V").
	    header("K", "V1","V2").
	    headers("User","MyApp","Charset","UTF-8").
		when().post("https://jsonplaceholder.typicode.com/photos").
		then().statusCode(200);
	}
	

}
