package com.bus.dto;

import java.time.LocalTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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

	@NotNull(message = "BusName Can't be null.")
	@NotBlank(message = "BusName Can't be Blank.")
	@NotEmpty (message = "BusName Can't be Empty.")
	
	private String busName;
	
	@NotNull(message = "driverName Can't be null.")
	@NotBlank(message = "driverName Can't be Blank.")
	@NotEmpty (message = "driverName Can't be Empty.")
	@Size(min = 3, max = 20, message = "driverName length should be between 3 and 20 characters.")
	private String driverName;
	
	
	@NotNull(message = "busType Can't be null.")
	@NotBlank(message = "busType Can't be Blank.")
	@NotEmpty (message = "busType Can't be Empty.")
	private String busType;
	
	
	@NotNull(message = "routeTo Can't be null.")
	@NotBlank(message = "routeTo Can't be Blank.")
	@NotEmpty (message = "routeTo Can't be Empty.")
	private String routeTo;
	
	
	@NotNull(message = "Arrival time can't be null.")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime arrivalTime ;
	
	
	@NotNull(message = "Departure time can't be null.")
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime departureTime;
	
	@NotNull(message = "Number of seats can't be null.")
	@Positive(message = "Number of seats should be greater than 0.")
	private Integer Seat;
	
	
	@NotNull(message = "Available seats can't be null.")
	@Min(value = 0, message = "Available seats can't be negative.")
	@Max(value = 100, message = "Available seats can't be greater than 100.")
	private Integer availableSeats;
}
