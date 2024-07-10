package org.baseclass;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateFlight extends BaseClass {

	String fNo = "";

	@Test(priority = 1, enabled = true)
	public void createFlight() {
		addHeader("Content-Type", "application/json");

		addReqBody("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		Response response = addReqType("POST", "https://omrbranch.com/api/flights");

		JsonPath path = response.jsonPath();
		Object object = path.get("data.id");
		System.out.println(object);

		Integer id = (Integer) object;
		String idNo = Integer.toString(id);
		fNo = idNo;

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	

	@Test(priority = 2)
	public void updateFlight() {
		addHeader("Content-Type", "application/json");

		addReqBody("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 10,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		Response response = addReqType("PUT", "https://omrbranch.com/api/flight/" + fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	

	@Test(priority = 3)
	public void updateFlight1() {
		addHeader("Content-Type", "application/json");

		addReqBody("{\r\n" + "    \"Destinations\": 56\r\n" + "}");

		Response response = addReqType("PATCH", "https://omrbranch.com/api/flight/" + fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	

	@Test(priority = 4, enabled = false)
	public void deleteFlight() {
		addHeader("Content-Type", "application/json");
		Response response = addReqType("DELETE", "https://omrbranch.com/api/flight/" + fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	

	@Test(priority = 5)
	public void listFlight() {
		addHeader("Content-Type", "application/json");

		Response response = addReqType("GET", "https://omrbranch.com/api/flights?page=1");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
	

	@Test(priority = 6)
	public void singleFlight() {
		addHeader("Content-Type", "application/json");

		Response response = addReqType("GET", "https://omrbranch.com/api/flight/" + fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsString = getResBodyAsString(response);
		System.out.println(resBodyAsString);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
}
