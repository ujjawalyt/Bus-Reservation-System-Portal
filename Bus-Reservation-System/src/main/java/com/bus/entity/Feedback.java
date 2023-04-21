package com.bus.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long feedbackId;
	
	private Integer driverRating;
	
	private Integer serviceRating;
	
	private Integer overallRating;
	
	private String comments;
	
	private LocalDate feedbackdate;
	
	@ManyToOne
	private Customer customer;
	
}
