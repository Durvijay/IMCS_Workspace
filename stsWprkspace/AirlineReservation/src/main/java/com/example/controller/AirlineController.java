package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Flight;
import com.example.dao.FlightDetailRepositoryDao;
import com.example.dao.FlightRepositoryDao;

@RestController
@RequestMapping("/reservation")
public class AirlineController {
	
	@Autowired
	FlightDetailRepositoryDao flightDetailsRepositoryDao;
	
	@Autowired
	FlightRepositoryDao flightRepositoryDao;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		return "working";
		
	}
	@RequestMapping(value="/flight/{id}",method=RequestMethod.GET)
	public Flight getFlightInfo(@PathVariable("id") Integer id) {
		return flightRepositoryDao.getFlightInfo(id);
	}
	
	@RequestMapping(value="/flight/{id}",method=RequestMethod.DELETE)
	public void deleteFlightInfo(@PathVariable("id") Integer id) {
		deleteFlightInfo(id);
	}
	
	@RequestMapping(value="/flight/{id}",method=RequestMethod.POST)
	public Flight updateFlightInfo(@RequestBody Flight flight) {
		return flightRepositoryDao.updateFlightInfo(flight);
	}
	
	@RequestMapping(value="/flight",method=RequestMethod.PUT)
	public Flight addFlightInfo(@RequestBody Flight flight) {
		return flightRepositoryDao.saveFlightInfo(flight);
	}
}
