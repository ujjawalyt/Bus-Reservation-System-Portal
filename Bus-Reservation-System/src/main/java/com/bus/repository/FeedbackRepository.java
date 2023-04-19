package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entity.Feedback;

public interface FeedbackRepository  extends JpaRepository<Feedback, Long>{

}
