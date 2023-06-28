package com.vaishnavi.search.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.search.entity.Airport;
import com.vaishnavi.search.entity.Flight;
import com.vaishnavi.search.repo.AirportRepository;
import com.vaishnavi.search.repo.FlightRepository;

@Service
public class SearchServiceImpl implements SearchService{
	
	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

	@Autowired
	private AirportRepository airportR;
	
	@Autowired
	private FlightRepository flightR;

	@Override
	public String addAirports(List<Airport> airports) {	
		airportR.saveAll(airports);
		logger.warn("Airports Added");
		return "Airports Added";
	}

	@Override
	public String addFlights(List<Flight> flights) {
		flightR.saveAll(flights);
		logger.warn("Flights Added");
		return "Flights Added";
	}
	

	@Override
	public List<String> getCodes() {
		List<Airport> airports = airportR.findAll();
		List<String> codes = new ArrayList<>();
		for(Airport airport:airports)
		{
			if(!airport.getIata().equals("\\N")) {
				codes.add(airport.getIata().trim() + " - " + airport.getCity().trim() + " (" + airport.getName().trim() + ")");
			}
		}
		logger.warn("Codes Retrieved");
		return codes;
	}

	@Override
	public List<Airport> searchAirports() {
		logger.warn("Got All Aiports");
		return airportR.findAll();
	}

	@Override
	public List<Flight> searchFlights() {
		logger.warn("Got All Flights");
		return flightR.findAll();
	}

	@Override
	public Flight updateFlights(String flightNumber, Flight flight) {
		Flight fdata=flightR.findById(flightNumber).get();
		fdata.setFlightNumber(flight.getFlightNumber());
		fdata.setDepartureTime(flight.getDepartureTime());
		fdata.setArrivalTime(flight.getArrivalTime());
		fdata.setAirline(flight.getAirline());
		fdata.setStatus(flight.getStatus());
		return flightR.save(fdata);
	}

	@Override
	public String deleteFlights(String flightNumber) {
		flightR.deleteById(flightNumber);
		logger.warn("Flight Deleted");
		return "Flight Deleted";
	}
	
	

}
