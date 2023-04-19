package com.bus.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Routes {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long routeId;
	private String startPoint;
	private String endPoint;
	private Double distance;
	
	@OneToMany(cascade = CascadeType.ALL)
	 private List<Buses> busList;

}
