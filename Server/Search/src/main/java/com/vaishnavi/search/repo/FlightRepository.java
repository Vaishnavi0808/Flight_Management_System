package com.vaishnavi.search.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vaishnavi.search.entity.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String>{

}
