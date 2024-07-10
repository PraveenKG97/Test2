package com.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetListFlight_1 {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		File file = new File("C:\\Users\\arvin\\eclipse-workspace\\API_Project\\src\\test\\resources\\ListFlight.json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		PagesFlight pagesFlight = mapper.readValue(file, PagesFlight.class);		
		
		int page = pagesFlight.getPage();
		System.out.println(page);
		
		int per_page = pagesFlight.getPer_page();
		System.out.println(per_page);
		
		int total = pagesFlight.getTotal();
		System.out.println(total);
		
		int total_pages = pagesFlight.getTotal_pages();
		System.out.println(total_pages);
		
		ArrayList<DataFlight> data = pagesFlight.getData();
		
		for (DataFlight d : data) {
			System.out.println(d.getId());
			System.out.println(d.getFlightName());
			System.out.println(d.getCountry());
			System.out.println(d.getDestinations());
			System.out.println(d.getURL());		
		}
		
		SupportFlight support = pagesFlight.getSupport();
		
		String url = support.getUrl();
		System.out.println(url);
		
		String text = support.getText();
		System.out.println(text);
	}

}
