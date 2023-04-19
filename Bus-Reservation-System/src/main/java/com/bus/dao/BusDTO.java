package com.bus.dao;

import java.time.LocalTime;

import com.bus.entity.Buses;
import com.bus.entity.Feedback;
import com.bus.entity.Routes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDTO {

	private String busName;
	private String driverName;
	private String busType;
	private String routeTo;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private Integer Seat;
}
