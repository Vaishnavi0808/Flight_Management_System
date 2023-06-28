package com.vaishnavi.fms.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vaishnavi.fms.bean.Airport;
import com.vaishnavi.fms.bean.Flight;

@FeignClient(name="Search", url="localhost:8100")
public interface SearchProxy {
	
	@PostMapping("/Search/AddAirports")
    public String addAirports(@RequestBody List<Airport> airports);
	
	@PostMapping("/Search/AddFlights")
	public String addFlights(@RequestBody List<Flight> flights);
	
	@GetMapping("/Search/Codes")
	public List<String> getCodes();
	
	@GetMapping("/Search/Airports")
	public List<Airport> searchAirports();
	
	@GetMapping("/Search/Flights")
	public List<Flight> searchFlights();
	
	

}
