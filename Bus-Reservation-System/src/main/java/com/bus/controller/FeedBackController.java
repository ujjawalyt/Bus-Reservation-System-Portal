package com.bus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.dto.FeedbackDto;
import com.bus.entity.Feedback;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.FeedbackNotFoundException;
import com.bus.exception.LoginException;
import com.bus.service.FeedBackService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

	
	@Autowired
	private FeedBackService feedBackService;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<Feedback> addFeedback_Handler(@Valid @RequestBody FeedbackDto feedbackDto,@PathVariable("id") Long id) 
			throws CustomerNotFoundException,FeedbackNotFoundException, LoginException{
		return new ResponseEntity<Feedback>(feedBackService.addFeedBack(feedbackDto, id),HttpStatus.CREATED);
	}
	
	@PutMapping("/add/{id}/{customerId}")
	public ResponseEntity<Feedback> updateFeedback_Handler(@Valid @RequestBody FeedbackDto feedbackDto,@PathVariable("id") Long id,
			@PathVariable("customerId") Long customerId) throws CustomerNotFoundException,FeedbackNotFoundException{
		return new ResponseEntity<Feedback>(feedBackService.updatefeedBack(feedbackDto, id, customerId),HttpStatus.CREATED);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<Feedback> ViewFeedback_Handler(@PathVariable("id") Long id) throws CustomerNotFoundException,FeedbackNotFoundException,AdminNotFoundException{
		return new ResponseEntity<Feedback>(feedBackService.viewFeedback(id),HttpStatus.CREATED);
	}
	@GetMapping("/views")
	public ResponseEntity<List<Feedback>> ViewAllFeedback_Handler() throws CustomerNotFoundException,FeedbackNotFoundException,AdminNotFoundException{
		return new ResponseEntity<List<Feedback>>(feedBackService.viewAllFeedback(),HttpStatus.CREATED);
	}
}
