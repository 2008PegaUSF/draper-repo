package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Shape;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShapeController {

	//localhost:numbers/api/getShapes
	@GetMapping("/getShapes")
	public List<Shape> getShapes(){
		List<Shape> shapes = new ArrayList<Shape>();
		
		Shape s1 = new Shape(1,"Square",4,true);
		Shape s2 = new Shape(2,"Triangle",3,true);
		Shape s3 = new Shape(3,"Circle",1,false);
		Shape s4 = new Shape(4,"Rhombus",4,true);
		
		shapes.add(s1);
		shapes.add(s2);
		shapes.add(s3);
		shapes.add(s4);
		
		return shapes;
	}
}
