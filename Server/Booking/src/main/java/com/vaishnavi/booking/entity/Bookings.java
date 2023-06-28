package com.vaishnavi.booking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bookings")
public class Bookings {
	
	@Transient
	public static final String SEQUENCE_NAME = "booking_sequence";
	
	@Id
	private int booking_id;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String departure;
	private String arrival;
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookings(int booking_id, String firstName, String lastName, String gender, int age, String departure,
			String arrival) {
		super();
		this.booking_id = booking_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.departure = departure;
		this.arrival = arrival;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	@Override
	public String toString() {
		return "Bookings [booking_id=" + booking_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + ", departure=" + departure + ", arrival=" + arrival + "]";
	}
	
	
	
}
