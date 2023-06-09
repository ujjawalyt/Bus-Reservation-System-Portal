package com.bus.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long customerId;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Reservation reservation;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Feedback> feedbacks;
	
	
}
