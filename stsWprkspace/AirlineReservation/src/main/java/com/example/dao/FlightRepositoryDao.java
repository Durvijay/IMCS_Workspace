package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Flight;
import com.example.repository.FlightRepository;

@Service
public class FlightRepositoryDao {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public Flight saveFlightInfo(Flight flight) {
		Flight flightresult=flightRepository.save(flight);
		return flightresult;
	}

	public Flight getFlightInfo(Integer id) {
		Flight flightresult=flightRepository.findOne(id);
		return flightresult;
	}

	public void deleteFlightInfo(Integer id) {
		flightRepository.delete(id);
	}

	public Flight updateFlightInfo(Flight flight) {
		Flight flightresult=flightRepository.save(flight);
		return flightresult;
	}

	
	
}
