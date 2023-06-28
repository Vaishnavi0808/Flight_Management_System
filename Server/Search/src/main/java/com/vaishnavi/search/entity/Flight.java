package com.vaishnavi.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="flights")
public class Flight {
	
	@Id
	private String flightNumber;
	private String departureTime;
	private String arrivalTime;
	private String airline;
	private String status;
	private double fare;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Flight(String flightNumber, String departureTime, String arrivalTime, String airline, String status,
			double fare) {
		super();
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.status = status;
		this.fare = fare;
	}


	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getFare() {
		return fare;
	}


	public void setFare(double fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", airline=" + airline + ", status=" + status + ", fare=" + fare + "]";
	}


	
}