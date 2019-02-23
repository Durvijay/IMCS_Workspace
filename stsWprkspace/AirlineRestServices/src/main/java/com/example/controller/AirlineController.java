package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Flight;
import com.example.bean.FlightDetails;
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
	@RequestMapping(value="/flight",method=RequestMethod.PUT)
	public FlightDetails addFlightInfo(@RequestBody FlightDetails flight) {
		return flightDetailsRepositoryDao.saveFlightDetailsInfo(flight);
	}
	@RequestMapping(value="/flight",method=RequestMethod.GET)
	public FlightDetails getFlightInfoById(@RequestBody FlightDetails flight) {
		return flightDetailsRepositoryDao.getFlightInfoByIdAndDate(flight);
	}
	
	
	@RequestMapping(value="/flight/{id}",method=RequestMethod.DELETE)
	public void deleteFlightInfo(@PathVariable("id") Integer id) {
		flightDetailsRepositoryDao.deleteFlightInfo(id);
	}
	
	@RequestMapping(value="/flight/{id}",method=RequestMethod.POST)
	public FlightDetails updateFlightInfo(@RequestBody FlightDetails flight) {
		return flightDetailsRepositoryDao.updateFlightInfo(flight);
	}
	
	
}
