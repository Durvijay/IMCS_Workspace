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
		 return flightDetailsRepository.save(flight);
	}

	public FlightDetails getFlightInfoByIdAndDate(FlightDetails flight) {
		return flightDetailsRepository.getFlightInfoByIdAndDate(flight);
	}

	public void deleteFlightInfo(Integer id) {
		flightDetailsRepository.delete(id);
		
	}

	public FlightDetails updateFlightInfo(FlightDetails flight) {
		return flightDetailsRepository.save(flight);
	}

	
}
