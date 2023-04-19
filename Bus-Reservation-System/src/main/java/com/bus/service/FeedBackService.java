package com.bus.service;

import java.util.List;

import com.bus.entity.Feedback;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.FeedbackNotFoundException;

public interface FeedBackService {

	
	public Feedback addFeedBack(Feedback feedback) throws CustomerNotFoundException, FeedbackNotFoundException;
	
	public Feedback updatefeedBack(Feedback feedback, Long feedbackId) throws CustomerNotFoundException, FeedbackNotFoundException;
	
	public Feedback viewFeedback(Long feedbackId) throws CustomerNotFoundException,AdminNotFoundException,FeedbackNotFoundException;
	
	public List<Feedback> viewAllFeedback() throws CustomerNotFoundException,AdminNotFoundException, FeedbackNotFoundException;
}
