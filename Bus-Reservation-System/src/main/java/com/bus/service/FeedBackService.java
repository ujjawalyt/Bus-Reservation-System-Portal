package com.bus.service;

import java.util.List;

import com.bus.dto.FeedbackDto;
import com.bus.entity.Feedback;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.FeedbackNotFoundException;
import com.bus.exception.LoginException;

public interface FeedBackService {

	public Feedback addFeedBack(FeedbackDto feedbackdto , Long customerId)
			throws CustomerNotFoundException, FeedbackNotFoundException,LoginException;

	public Feedback updatefeedBack(FeedbackDto feedbackdto, Long feedbackId, Long customerId)
			throws CustomerNotFoundException, FeedbackNotFoundException;

	public Feedback viewFeedback(Long feedbackId)
			throws CustomerNotFoundException, AdminNotFoundException, FeedbackNotFoundException;

	public List<Feedback> viewAllFeedback()
			throws CustomerNotFoundException, AdminNotFoundException, FeedbackNotFoundException;
}
