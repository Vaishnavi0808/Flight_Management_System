package com.vaishnavi.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaishnavi.search.entity.Airport;
import com.vaishnavi.search.entity.Flight;
import com.vaishnavi.search.service.SearchService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Search")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	//Adding the list of airports
	@PostMapping("/AddAirports")
    public String addAirports(@RequestBody List<Airport> airports) {
        return searchService.addAirports(airports);
    }
	
	//Adding the list of flights
	@PostMapping("/AddFlights")
	public String addFlights(@RequestBody List<Flight> flights) {
		return searchService.addFlights(flights);
    }
	
	//Getting the list of cities 
	@GetMapping("/Codes")
	public List<String> getCodes() {
		return searchService.getCodes();
	}
	
	//Getting the list of airports
	@GetMapping("/Airports")
	public List<Airport> searchAirports() {
		return searchService.searchAirports();
	}
	
	@GetMapping("/Flights")
	public List<Flight> searchFlights() {
		return searchService.searchFlights();
	}
	
	//Updating the flight by flightNumber
	@PutMapping("/UpdateFlights/{flightNumber}")
	public Flight updateFlights(@PathVariable String flightNumber, @RequestBody Flight flight) {
		return searchService.updateFlights(flightNumber,flight);
	}
	
	//To delete the flight using flightNumber
	@DeleteMapping("/DeleteFlights/{flightNumber}")
	public String deleteFlights(@PathVariable String flightNumber)
	{
		return searchService.deleteFlights(flightNumber);
	}

}
