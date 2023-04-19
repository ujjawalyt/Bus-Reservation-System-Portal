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
public class Feedback {

	
	private Long feedbackId;
	private Integer driverRating;
	private Integer serviceRating;
	private Integer overallRating;
	private String comments;
	private LocalDate feedbackdate;
	
	
}
