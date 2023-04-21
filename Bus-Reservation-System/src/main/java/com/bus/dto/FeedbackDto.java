package com.bus.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

	@NotNull(message = "Driver rating can't be null.")
	@Max(value = 5, message = "Driver rating can't be greater than 5.")
	private Integer driverRating;
	
	@NotNull(message = "Service rating can't be null.")
	@Max(value = 5, message = "Service rating can't be greater than 5.")
	private Integer serviceRating;
	
	@NotNull(message = "Overall rating can't be null.")
	@Max(value = 5, message = "Overall rating can't be greater than 5.")
	private Integer overallRating;
	
	@NotNull(message = "Comment Can't be null.")
	@NotBlank(message = "Comment Can't be Blank.")
	@NotEmpty (message = "Comment Can't be Empty.")
	private String comments;
	
	@PastOrPresent(message = "Feedback date can't be in the future.")
	private LocalDate feedbackdate =LocalDate.now();
}
