package com.vaishnavi.fms.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="airports")
public class Airport { 
	
	@Id
	private String name;
	private String city;
	private String country;
	private String iata;
	private String icao;
	private double lat;
	private double lon;
	private String timezone;
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(String name, String city, String country, String iata, String icao, double lat, double lon,
			String timezone) {
		super();
		this.name = name;
		this.city = city;
		this.country = country;
		this.iata = iata;
		this.icao = icao;
		this.lat = lat;
		this.lon = lon;
		this.timezone = timezone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}
	public String getIcao() {
		return icao;
	}
	public void setIcao(String icao) {
		this.icao = icao;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	@Override
	public String toString() {
		return "Airport [name=" + name + ", city=" + city + ", country=" + country + ", iata=" + iata + ", icao=" + icao
				+ ", lat=" + lat + ", lon=" + lon + ", timezone=" + timezone + "]";
	}
	
	
	
}
