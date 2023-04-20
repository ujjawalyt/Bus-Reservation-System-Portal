package com.bus.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	private LocalTime arrivalTime;
	
	private LocalTime departureTime;
	
	@NotNull(message = "routeTo Can't be null.")
	@NotBlank(message = "routeTo Can't be Blank.")
	@NotEmpty (message = "routeTo Can't be Empty.")
	private Integer Seat;
}
