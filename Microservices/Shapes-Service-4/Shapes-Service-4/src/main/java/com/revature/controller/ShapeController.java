package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Shape;
import com.revature.repo.ShapeDAO;

@RestController
@CrossOrigin
@RequestMapping("/shapes")
public class ShapeController {

	@Autowired
	private ShapeDAO shapeDAO;
	
	@GetMapping("/insertShapes")
	public String insertShapes() {		
		Shape s1 = new Shape(1,"Square",4,true);
		Shape s2 = new Shape(2,"Triangle",3,true);
		Shape s3 = new Shape(3,"Circle",1,false);
		Shape s4 = new Shape(4,"Rhombus",4,true);
		
		shapeDAO.save(s1);
		shapeDAO.save(s2);
		shapeDAO.save(s3);
		shapeDAO.save(s4);
		
		return "Success!";
	}
	
	@GetMapping("/getShapes")
	public List<Shape> getShapes(){
		return shapeDAO.findAll();
	}
}
