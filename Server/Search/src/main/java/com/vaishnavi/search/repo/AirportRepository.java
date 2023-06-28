package com.vaishnavi.search.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vaishnavi.search.entity.Airport;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {

}