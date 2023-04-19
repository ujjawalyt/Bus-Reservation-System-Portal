package com.bus.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buses {
   
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long busId;
	private String busName;
	private String driverName;
	private String busType;
	private String routeTo;
	private LocalTime arrivalTime=LocalTime.now();
	private LocalTime departureTime=LocalTime.MIDNIGHT;
	private Integer Seat;
	private Integer availableSeats;
	
	@OneToOne
	private Feedback feedback;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Routes route;
}
