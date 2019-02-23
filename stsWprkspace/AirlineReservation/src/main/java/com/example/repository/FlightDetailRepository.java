package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.FlightDetails;

@Repository
public interface FlightDetailRepository extends CrudRepository<FlightDetails, Integer>{

}
