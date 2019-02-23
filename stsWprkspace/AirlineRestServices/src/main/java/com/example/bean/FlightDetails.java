package com.example.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class FlightDetails implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer flightDetailId;

	@OneToOne
	@JoinColumn(name = "flight_flightId")
	@JsonBackReference
	private Flight flightId;
	private Date flightDepartureDate;
	private Double price;
	private Integer availableSeats;

}
