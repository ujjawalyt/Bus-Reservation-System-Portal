package com.bus.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentCustomerSession {

	@Id
	private Long customerId;
	private String customerKey;
	private LocalDateTime localDateTime;
}
