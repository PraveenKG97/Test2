package org.baseclass;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Swagger extends BaseClass{
	
	@Test
	public void login() {
		
		addHeader("accept", "application/json");
		
		addBasicAuth("kgpraveen96@gmail.com", "Password@123");
		
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);
		
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
}
