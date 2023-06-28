package com.vaishnavi.search.service;

import java.util.List;

import com.vaishnavi.search.entity.Airport;
import com.vaishnavi.search.entity.Flight;

public interface SearchService {
	
	public String addAirports(List<Airport> airports);
	
	public String addFlights(List<Flight> flights);
	
	public List<String> getCodes();
	
	public List<Airport> searchAirports();
	
	public List<Flight> searchFlights();

	public Flight updateFlights(String flightNumber, Flight flight);

	public String deleteFlights(String flightNumber);

}
