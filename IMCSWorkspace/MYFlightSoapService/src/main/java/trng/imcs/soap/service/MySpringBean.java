package trng.imcs.soap.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import trng.imcs.soap.stub.Flight;
import trng.imcs.soap.stub.FlightFare;

@Component
public class MySpringBean {
	public List<Flight> getFlights() {
		List<Flight> flights = new ArrayList<Flight>();
		Flight flight = new Flight();
		FlightFare fare = new FlightFare();
		fare.setBasicPrice(new BigDecimal(300.34));
		flight.setFare(fare);
		flight.setFlightNo(new BigInteger("3434"));
		flight.setName("Emirates");
		flights.add(flight);
		return flights;
	}
}
