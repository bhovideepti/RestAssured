package com.rest.RestUtility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Testime_measurement {
	
	@Test
	public void testResponsetime(){
		long t = given().
		get("https://jsonplaceholder.typicode.com/photos").time();
		System.out.println(+t);
	
	}
	
	
	@Test
	public void testResponsetimeTimeUnit(){
		long t = given().
		get("https://jsonplaceholder.typicode.com/photos").timeIn(TimeUnit.MILLISECONDS);
			
	}
	

}
