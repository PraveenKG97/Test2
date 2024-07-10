package com.base;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetListFlight {
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fileReader = new FileReader("C:\\Users\\arvin\\eclipse-workspace\\API_Project\\src\\test\\resources\\ListFlight.json");
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("page");
		System.out.println(object);
		
		Object object2 = jsonObject.get("per_page");
		System.out.println(object2);
		
		Object object3 = jsonObject.get("total");
		System.out.println(object3);
		
		Object object4 = jsonObject.get("total_pages");
		System.out.println(object4);
		
		Object object5 = jsonObject.get("data");
		
		JSONArray array = (JSONArray) object5;
		
		for (int i=0; i<array.size() ; i++) {
			Object object6 = array.get(i);
			
			JSONObject jsonObject2 = (JSONObject) object6;
			Object object7 = jsonObject2.get("id");
			System.out.println(object7);
			
			Object object8 = jsonObject2.get("flightName");
			System.out.println(object8);
			
			Object object9 = jsonObject2.get("Country");
			System.out.println(object9);
			
			Object object10 = jsonObject2.get("Destinations");
			System.out.println(object10);
			
			Object object11 = jsonObject2.get("URL");
			System.out.println(object11);
			
					
		}
		
		 Object object12 = jsonObject.get("support");
		 
		 JSONObject jsonObject3=(JSONObject)object12;
		    
		    Object object13 = jsonObject3.get("url");
		    System.out.println(object13);
		    
		    Object object14 = jsonObject3.get("text");
		    System.out.println(object14);
	}
}
