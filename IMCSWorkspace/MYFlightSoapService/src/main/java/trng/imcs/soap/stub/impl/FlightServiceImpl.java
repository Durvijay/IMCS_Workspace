package trng.imcs.soap.stub.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trng.imcs.soap.service.MySpringBean;
import trng.imcs.soap.stub.BookFlightRequest;
import trng.imcs.soap.stub.BookFlightResponse;
import trng.imcs.soap.stub.Flight;
import trng.imcs.soap.stub.FlightFare;
import trng.imcs.soap.stub.FlightsService;
import trng.imcs.soap.stub.GetFlightsRequest;
import trng.imcs.soap.stub.GetFlightsResponse;

@WebService(endpointInterface="trng.imcs.soap.stub.FlightsService")
@Service("flightsWs")
public class FlightServiceImpl implements FlightsService {

	@Autowired
	private MySpringBean flgihtBean;
	public GetFlightsResponse getFlights(GetFlightsRequest parameters) {
		GetFlightsResponse response = new GetFlightsResponse();
		response.getFlights().addAll(flgihtBean.getFlights());
		return response;
	}

	public BookFlightResponse bookFlights(BookFlightRequest parameters) {
		return new BookFlightResponse();
	}

}
