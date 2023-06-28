package com.vaishnavi.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaishnavi.fms.bean.Airport;
import com.vaishnavi.fms.bean.Flight;
import com.vaishnavi.fms.proxy.SearchProxy;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SearchController {
	
	@Autowired
	private SearchProxy search;
	
	@GetMapping("/codes")
	public List<String> getCodes() {
		return search.getCodes();
	}
	
	@GetMapping("/flights")
	public List<Flight> getFlights() {
		return search.searchFlights();
	}
	
	@GetMapping("/airports")
	public List<Airport> getAirports() {
		return search.searchAirports();
	}

}
