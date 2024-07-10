package com.base;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagesFlight {
	 	private int page;
	 	private int per_page;
	 	private int total;
	 	private int total_pages;
	 	private ArrayList<DataFlight> data;
	 	private SupportFlight support;
}
