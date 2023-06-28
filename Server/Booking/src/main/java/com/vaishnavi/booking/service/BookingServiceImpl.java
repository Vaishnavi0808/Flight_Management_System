package com.vaishnavi.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaishnavi.booking.entity.Bookings;
import com.vaishnavi.booking.repo.BookingRepo;
import com.vaishnavi.booking.util.SequenceGeneratorService;

@Service
public class BookingServiceImpl implements BookingService {
	
	//private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	
	@Autowired
	private BookingRepo repo1;
	
	@Autowired
	private SequenceGeneratorService generator;
	
	@Override
	public List<Bookings> getAllBookings() {
		return repo1.findAll();
	}

	@Override
	public void addBooking(Bookings booking) {
		booking.setBooking_id(generator.getSequenceNumber(Bookings.SEQUENCE_NAME));
		repo1.save(booking);
		//logger.warn("Airports Added");
	}

	@Override
	public Bookings getBookingById(int booking_id) {
		return repo1.findById(booking_id).get();
		
	}

	@Override
	public Bookings updateBooking(int booking_id, Bookings booking) {
		Bookings b1=repo1.findById(booking_id).get();
		b1.setFirstName(booking.getFirstName());
		b1.setLastName(booking.getLastName());
		b1.setGender(booking.getGender());
		b1.setAge(booking.getAge());
		b1.setDeparture(booking.getDeparture());
		b1.setArrival(booking.getArrival());
		return repo1.save(b1);
	}

	@Override
	public void deleteBooking(int booking_id) {
		repo1.deleteById(booking_id);
	}
	
	
	
	
	

}
