package com.example.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Flight implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer flightId;
	private Integer airlineId;
	private String airlineName;
	private String fromLocation;
	private String toLocation;
	private Date departureTime;
	private Date arrivalTime;
	private Double duration;
	private Integer totalSeats;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JsonManagedReference
	private FlightDetails flightDetails;

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineId=" + airlineId + ", airlineName=" + airlineName
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", duration=" + duration + ", totalSeats=" + totalSeats
				+ ", flightDetails=" + flightDetails + "]";
	}
	
	
}
