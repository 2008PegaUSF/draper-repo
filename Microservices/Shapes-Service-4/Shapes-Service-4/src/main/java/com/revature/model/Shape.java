package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shape {

	@Id
	@Column(name = "shape_id")
	private int id;
	
	@Column(name = "shape_name")
	private String name;
	
	@Column(name = "sides")
	private int sides;
	
	@Column(name = "is_polygon")
	private boolean isPolygon;
}
