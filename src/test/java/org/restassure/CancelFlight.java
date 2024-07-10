package org.restassure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CancelFlight {
	public static void main(String[] args) {

		RequestSpecification reqspec;

		reqspec = RestAssured.given();

		reqspec = reqspec.header("Content-Type", "application/json");

		Response response = reqspec.delete("https://omrbranch.com/api/flight/29717");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asString = response.asString();
		System.out.println(asString);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}
}
