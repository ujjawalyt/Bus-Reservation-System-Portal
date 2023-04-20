package com.bus.dto;

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
public class CustomerDTO {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
}
