package org.baseclass;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Flight extends BaseClass {

	@Test
	public void createFlight () {
		
		addHeader("Content-Type", "application/json");
		
		addReqBody("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		
		Response response = addReqType("POST", "https://www.omrbranch.com/api/flights");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		
	}
}
