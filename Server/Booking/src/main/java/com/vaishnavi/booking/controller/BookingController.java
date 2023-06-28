package com.vaishnavi.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaishnavi.booking.entity.Bookings;
import com.vaishnavi.booking.service.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingController {
	
	@Autowired
	private BookingService service1;
	
	@GetMapping("/getBookings")
	public List<Bookings> getAllBookings()
	{
		return service1.getAllBookings();
	}
	
	@PostMapping("/addBookings")
	public void addBooking(@RequestBody Bookings booking)
	{
		service1.addBooking(booking);
	}
	
	@GetMapping("/getBooking/{booking_id}")
	public Bookings getBookingById(@PathVariable int booking_id)
	{
		return service1.getBookingById(booking_id);
	}
	
	@PutMapping("/updateBooking/{booking_id}")
	public Bookings updateBooking(@PathVariable int booking_id,@RequestBody Bookings booking)
	{
		return service1.updateBooking(booking_id,booking);
	}

	@DeleteMapping("/deleteBooking/{booking_id}")
	public void deleteBooking(@PathVariable int booking_id)
	{
		service1.deleteBooking(booking_id);
	}
	
}
