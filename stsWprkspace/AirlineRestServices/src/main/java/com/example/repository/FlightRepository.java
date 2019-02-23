package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer>{

}
