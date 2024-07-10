package org.restassure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateFlight1 {
public static void main(String[] args) {
		
		RequestSpecification reqspec;
		
		 reqspec = RestAssured.given();
		
		 reqspec = reqspec.header("Content-Type","application/json");
		 
		  reqspec = reqspec.body("{\r\n"
		 		+ "    \"Destinations\": 48\r\n"
		 		+ "}");
		 
		 Response response = reqspec.patch("https://omrbranch.com/api/flight/29717");
		 
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
		 
		 String asString = response.asString();
		 System.out.println(asString);
		 
		 String asPrettyString = response.asPrettyString();
		 System.out.println(asPrettyString);
					
	}
	
}
