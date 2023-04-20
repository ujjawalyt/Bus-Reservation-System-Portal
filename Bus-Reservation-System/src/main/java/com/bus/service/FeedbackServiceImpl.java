package com.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.entity.CurrentCustomerSession;
import com.bus.entity.Feedback;
import com.bus.exception.AdminNotFoundException;
import com.bus.exception.CustomerNotFoundException;
import com.bus.exception.FeedbackNotFoundException;
import com.bus.repository.CurrentCustomerSessionDao;
import com.bus.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedBackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private CurrentCustomerSessionDao currentCustomerSessionDao;

	@Override
	public Feedback addFeedBack(Feedback feedback, Long customerId)
			throws CustomerNotFoundException, FeedbackNotFoundException {
		if (customerId == null) {
			throw new CustomerNotFoundException("Invalid customerId");
		}

		Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao.findById(customerId);

		if (isCurrent.isEmpty()) {
			throw new CustomerNotFoundException("Customer is not logged in with this id- " + customerId);
		}
		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback updatefeedBack(Feedback feedback, Long feedbackId, Long customerId)
			throws CustomerNotFoundException, FeedbackNotFoundException {
		if (customerId == null) {
			throw new CustomerNotFoundException("Invalid customerId");
		}
		Optional<CurrentCustomerSession> isCurrent = currentCustomerSessionDao.findById(customerId);

		if (isCurrent.isEmpty()) {
			throw new CustomerNotFoundException("Customer is not logged in with this id- " + customerId);
		}
		Optional<Feedback> isOptional = feedbackRepository.findById(feedbackId);
		if (isOptional.isEmpty()) {
			throw new CustomerNotFoundException("No feedback is present with this id or by this customer" + feedbackId);
		}
		Feedback updateFeedback = isOptional.get();
		updateFeedback.setComments(feedback.getComments());
		updateFeedback.setDriverRating(feedback.getDriverRating());
		updateFeedback.setOverallRating(feedback.getOverallRating());
		updateFeedback.setServiceRating(feedback.getServiceRating());
		return feedbackRepository.save(updateFeedback);

	}

	@Override
	public Feedback viewFeedback(Long feedbackId)
			throws CustomerNotFoundException, AdminNotFoundException, FeedbackNotFoundException {
		Optional<Feedback> isOptional = feedbackRepository.findById(feedbackId);
		if (isOptional.isEmpty()) {
			throw new FeedbackNotFoundException("No feedback is present with this id or by this customer" + feedbackId);
		}
		return isOptional.get();

	}

	@Override
	public List<Feedback> viewAllFeedback()
			throws CustomerNotFoundException, AdminNotFoundException, FeedbackNotFoundException {
		return feedbackRepository.findAll();
	}

}
