package com.bus.dto;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	@NotNull(message = "UserName Can't be null.")
	@NotBlank(message = "UserName Can't be Blank.")
	@NotEmpty (message = "UserName Can't be Empty.")
	@Size(min = 3, max = 20, message = "UserName length should be between 3 and 20 characters.")
	private String username;
	
	private String password;
	
	@NotNull(message = "First Name Can't be null.")
	@NotBlank(message = "First Name Can't be Blank.")
	@NotEmpty (message = "First Name Can't be Empty.")
	@Size(min = 3, max = 20, message = "First Name length should be between 3 and 20 characters.")
	
	private String firstName;
	
	@NotNull(message = "Last Name Can't be null.")
	@NotBlank(message = "Last Name Can't be Blank.")
	@NotEmpty (message = "Last Name Can't be Empty.")
	@Size(min = 3, max = 20, message = "Last Name length should be between 3 and 20 characters.")
	private String lastName;
	
	
	@NotNull(message = "Mobile Number cannot be null.")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Invalid Mobile Number.")
	private String mobileNumber;
	
	@Email
	@Column(unique = true)
	private String email;
}
