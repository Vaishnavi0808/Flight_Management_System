package com.vaishnavi.booking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vaishnavi.booking.entity.Bookings;
import com.vaishnavi.booking.repo.BookingRepo;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {
	
	private Bookings booking = new Bookings(1, "Vaishnavi", "Sarode", "Female", 21,  "Nagpur", "Mumbai");
	private List<Bookings> bookings = new ArrayList<Bookings>();
	
	//private List<String> result = new ArrayList<String>();
	
	@Mock
	private BookingRepo bookingRepo;
	
	@InjectMocks
	private BookingServiceImpl bookingService;
	
	@Test
	void getAllBookingstest() {
		when(bookingRepo.findAll()).thenReturn(bookings);
		assertEquals(bookings, bookingService.getAllBookings());
	}
	
	@Test
	void getBookingByIdTest() {
		int booking_id = 1;
		Optional<Bookings> bookingOptional = Optional.of(booking);
		when(bookingRepo.findById(booking_id)).thenReturn(bookingOptional);
		assertEquals(booking, bookingService.getBookingById(booking_id));
	}
	
//	@Test
//	void addBookingTest() {
//		when(bookingRepo.save(booking)).thenReturn(booking);
//		assertEquals(booking, bookingService.addBooking(booking));
//	}
}
