package com.vaishnavi.search.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vaishnavi.search.entity.Airport;
import com.vaishnavi.search.entity.Flight;
import com.vaishnavi.search.repo.AirportRepository;
import com.vaishnavi.search.repo.FlightRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class SearchServiceImplTest {

	private Airport airport = new Airport("Chhatrapati Shivaji Intl ", "Mumbai", "India", "BOM", "VABB", 19.0886993408, 72.8678970337, "5.5");
	private List<Airport> airports = new ArrayList<Airport>();
	
	
	private Flight flight = new Flight("C1", "7:00 AM", "10:00 AM",  "United", "Delayed",4500);
	private List<Flight> flights = new ArrayList<Flight>();
	
	private List<String> result = new ArrayList<String>();
	
	@Mock
	private AirportRepository airportRepo;
	
	@Mock
	private FlightRepository flightRepo;

	@InjectMocks
	private SearchServiceImpl searchService;
	
	@BeforeEach
	public void initialize() {
		airports.add(airport);
		flights.add(flight);
		result.add("BOM - Mumbai (Chhatrapati Shivaji Intl)");
	}
	
	@Test
	void addAirportsTest() {
		when(airportRepo.saveAll(airports)).thenReturn(airports);
		assertEquals("Airports Added", searchService.addAirports(airports));
	}
	
	@Test
	void addFlightsTest() {
		when(flightRepo.saveAll(flights)).thenReturn(flights);
		assertEquals("Flights Added", searchService.addFlights(flights));
	}
	
	@Test
	void getCodesTest() {
		when(airportRepo.findAll()).thenReturn(airports);
		assertEquals(result, searchService.getCodes());
	}
	
	@Test
	void searchAirportsTest() {
		when(airportRepo.findAll()).thenReturn(airports);
		assertEquals(airports, searchService.searchAirports());
	}
	
	@Test
	void searchFlightsTest() {
		when(flightRepo.findAll()).thenReturn(flights);
		assertEquals(flights, searchService.searchFlights());
	}
	
//	@Test
//	void updateFlightsTest() {
//		when(flightRepo.findAll()).thenReturn(flights);
//		assertEquals(flights, searchService.updateFlights(null, flight));
//	}

}
