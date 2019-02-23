package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.FlightDetails;

@Repository
public interface FlightDetailRepository extends CrudRepository<FlightDetails, Integer> {

	@Query("SELECT d.flight_departure_date,d.flight_detail_id,d.flight_flight_id,d.price FROM flight f,flight_details d where f.flight_id=d.flight_flight_id and f.flight_id='8' and f.departure_time='2017-12-06 13:52:27'")
	FlightDetails getFlightInfoByIdAndDate(FlightDetails details);
}
