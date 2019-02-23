package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.FlightDetails;
import com.example.repository.FlightDetailRepository;

@Service
public class FlightDetailRepositoryDao {

	@Autowired
	private FlightDetailRepository flightDetailsRepository;
	
	public FlightDetails saveFlightDetailsInfo(FlightDetails flight) {
		FlightDetails flightresult=flightDetailsRepository.save(flight);
		return flightresult;
	}
}
