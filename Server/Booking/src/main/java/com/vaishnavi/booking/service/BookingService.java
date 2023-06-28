package com.vaishnavi.booking.service;

import java.util.List;

import com.vaishnavi.booking.entity.Bookings;

public interface BookingService {

	public List<Bookings> getAllBookings();

	public void addBooking(Bookings booking);

	public Bookings getBookingById(int booking_id);

	public Bookings updateBooking(int booking_id, Bookings booking);

	public void deleteBooking(int booking_id);

}
