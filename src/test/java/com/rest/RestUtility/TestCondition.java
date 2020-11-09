package com.rest.RestUtility;

import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestCondition {
	
//	@Test
	public void testJSONpath(){
	String json1 = 
			when().
			get("https://jsonplaceholder.typicode.com/photos").
			then().extract().asString();
	
	JsonPath jsonpath = new JsonPath(json1).setRoot("RestResponse");
	
	List<String> list = jsonpath.get("title");
	System.out.println(list.size());
	}
	
	//@Test
	public void testHeaders(){
		Response res = when().get("https://reqres.in/api/users?page=1");

		Headers headers = res.getHeaders();
		for(Header h: headers){
			System.out.println(h.getName() + ":"+ h.getValue());
		}
	}
	
	
	@Test
	public void testCookies(){
		Response res = when().get("https://reqres.in/api/users?page=1");
		Map<String,String> cookie1 = res.getCookies();
		
		for(Map.Entry<String, String> entry1: cookie1.entrySet()){
			System.out.println(entry1.getKey()+ ":"+ entry1.getValue());
		
		}
	
	}
	
	
	
		

}

