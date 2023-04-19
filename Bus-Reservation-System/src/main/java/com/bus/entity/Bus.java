package com.bus.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
 
	private Long busId;
	private String busName;
	private String driverName;
	private String busType;
	private String routeTo;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private Integer Seat;
	private Integer availableSeats;
}
