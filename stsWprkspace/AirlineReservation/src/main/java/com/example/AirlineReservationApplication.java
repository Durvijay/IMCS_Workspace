package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.bean.Flight;
import com.example.bean.FlightDetails;
import com.example.dao.FlightDetailRepositoryDao;
import com.example.dao.FlightRepositoryDao;

@SpringBootApplication
public class AirlineReservationApplication implements CommandLineRunner{

	@Autowired
	FlightRepositoryDao flightRepository;
	@Autowired
	FlightDetailRepositoryDao detailRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Flight flight=new Flight();
		flight.setAirlineName("Ethihad");
		flight.setAirlineId(123456);
		flight.setFromLocation("LAX");
		flight.setToLocation("DFW");
		flight.setDepartureTime(new Date());
		flight.setArrivalTime(new Date());
		flight.setDuration(4.30);
		flight.setTotalSeats(480);
		
		System.out.println(flight.getFlightId());
		FlightDetails details=new FlightDetails();
		details.setFlightId(flight);
		details.setAvailableSeats(320);
		details.setPrice(468.56);
		flight.setFlightDetails(details);
		
		flight=flightRepository.saveFlightInfo(flight);
		System.out.println(flight);
		
		//detailRepository.saveFlightDetailsInfo(details);
	}
}
