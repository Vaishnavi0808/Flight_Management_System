package com.vaishnavi.booking.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vaishnavi.booking.entity.Bookings;

@Repository
public interface BookingRepo extends MongoRepository<Bookings, Integer>{


}
