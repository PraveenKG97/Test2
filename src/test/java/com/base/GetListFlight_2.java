package com.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetListFlight_2 {

public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		File file = new File("C:\\Users\\arvin\\eclipse-workspace\\API_Project\\src\\test\\resources\\TestFlight.json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<DataFlight> dataFlights = new ArrayList<DataFlight>();
		DataFlight d1 = new DataFlight(3, "AirIndia", "India", "28", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DataFlight d2 = new DataFlight(33, "AirIndia", "India", "20", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DataFlight d3 = new DataFlight(36, "Srilankan AriLines", "India", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Sri_Lanka");
		DataFlight d4 = new DataFlight(42, "AirIndia.Raj", "India", "98", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DataFlight d5 = new DataFlight(49, "AirIndia", "India", "88", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DataFlight d6 = new DataFlight(59, "AirIndia", "India", "87", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		
		dataFlights.add(d1);
		dataFlights.add(d2);
		dataFlights.add(d3);
		dataFlights.add(d4);
		dataFlights.add(d5);
		dataFlights.add(d6);
		
		SupportFlight supportFlight = new SupportFlight("https:\\/\\/www.omrbranch.com", "For Joining Automation Course, Please Contact-Velmurugan 9944152058");
		
		
		PagesFlight pagesFlight = new PagesFlight(1,6,7544,1258, dataFlights, supportFlight);
		
		mapper.writeValue(file, pagesFlight);
}
}