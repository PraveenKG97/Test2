package com.swaggerpojo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class SwaggerDoc extends BaseClass{

	String logtoken ;
	String iD="";
	
	
	@Test(priority = 9)
	public void changeProfilePic() {
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
		addMultiPartFormData("profile_picture", new File(System.getProperty("user.dir")+"\\src\\test\\resources\\download.jpg"));
		
		Response response = addReqType("POST", "https://omrbranch.com/api/changeProfilePic");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		
		ProfilePic_Output_Pojo pic_Output_Pojo = response.as(ProfilePic_Output_Pojo.class);

		String message = pic_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Profile updated Successfully", "verify the success message");
		
}
	
	@Test(priority = 8)
	public void cityList() {
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
			
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo("35");
		addReqBody(cityList_Input_Pojo);
		
		Response response = addReqType("POST", "https://omrbranch.com/api/cityList");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		DatumCityList datumCityList = cityList_Output_Pojo.getData().get(632);
		String name = datumCityList.getName();
		Assert.assertEquals(name, "Salem", "Verify city Salem");
		
					
	}
	
	@Test(priority = 7)
	public void stateList() {
		
		addHeader("accept", "application/json");
		
		Response response = addReqType("GET", "https://omrbranch.com/api/stateList");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		StateList_output_Pojo stateList_output_Pojo = response.as(StateList_output_Pojo.class);
		DatumStateList datumStateList = stateList_output_Pojo.getData().get(34);
		String name = datumStateList.getName();
		Assert.assertEquals(name, "Tamil Nadu", "Verify state TamilNadu");
		
	}
	
	@Test(priority = 6)
	public void searchProduct() {
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo("nuts");
		addReqBody(searchProduct_Input_Pojo);
		
		Response response = addReqType("POST", "https://omrbranch.com/api/searchProduct");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		DatumSearch datumSearch = searchProduct_Output_Pojo.getData().get(0);
		String type = datumSearch.getType();
		Assert.assertEquals(type, "product", "Verify search product");
		
		
		
	}
	
	@Test(priority = 5)
	public void deleteAddress() {
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(iD);
		addReqBody(deleteUserAddress_Input_Pojo);
		
		
		Response response = addReqType("DELETE", "https://omrbranch.com/api/deleteAddress");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify Address deleted successfully");

	}
	
	@Test(priority = 4)
	public void getUserAddress() {
		
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		
		lstheader.add(h1);
		lstheader.add(h2);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
			
		Response response = addReqType("GET", "https://omrbranch.com/api/getUserAddress");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		Datum datum = getUserAddress_Output_Pojo.getData().get(0);
		String first_name = datum.getFirst_name();
		Assert.assertEquals(first_name, "Praveen", "Verify first name");
		
	}
	
	@Test(priority = 3)
	public void updateAddress() {
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(iD, "Praveen", "KG", "7667588599", "Krishna Nivasam", 33, 3378, 101, "636007", "Salem", "Home");
		addReqBody(updateUserAddress_Input_Pojo);
		
		
		Response response = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify Address updated successfully");

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
	
	@Test(priority = 2)
	public void addAddress() {
		
		//1.Headers
		
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Praveen", "KG", "7667588599", "Krishna Nivasam", 33, 320, 91, "636007", "Salem", "Home");
		addReqBody(addUserAddress_Input_Pojo);
		
		Response response = addReqType("POST", "https://omrbranch.com/api/addUserAddress");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		
		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address added successfully", "Verify Address added successfully");
		
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		
		Integer address_id = addUserAddress_Output_Pojo.getAddress_id();
		iD = address_id.toString();
		
	}
	
	@Test(priority = 1)
	public void login() {
		
		addHeader("accept", "application/json");
		
		addBasicAuth("kgpraveen96@gmail.com", "Password@123");
		
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals(first_name, "Praveen", "Verify first name");
		
		logtoken = login_Output_Pojo.getData().getLogtoken();
		
	}
}
