package com.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shape {

	private int id;
	private String name;
	private int sides;
	private boolean polygon;
}
