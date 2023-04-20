package com.bus.dto;

import java.util.List;

import com.bus.entity.Buses;
import com.bus.entity.Routes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {

	private String startPoint;
	private String endPoint;
	private Double distance;
}
