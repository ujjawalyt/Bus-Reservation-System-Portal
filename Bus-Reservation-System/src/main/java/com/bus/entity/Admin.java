package com.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long adminId;
	
	@NotNull(message = "UserName Can't be null.")
	@NotBlank(message = "UserName Can't be Blank.")
	@NotEmpty (message = "UserName Can't be Empty.")
	@Size(min = 3, max = 20, message = "UserName length should be between 3 and 20 characters.")
	private String username;
	
	
	private String password;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull(message = "Admin Name Can't be null.")
	@NotBlank(message = "Admin Name Can't be Blank.")
	@NotEmpty (message = "Admin Name Can't be Empty.")
	@Size(min = 3, max = 20, message = "Admin Name length should be between 3 and 20 characters.")
	private String name;
	

	
}
