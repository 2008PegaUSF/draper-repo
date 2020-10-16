package com.revature.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Shape;

public interface ShapeDAO extends CrudRepository<Shape, Integer>{

	public List<Shape> findAll();
	public Shape save(Shape s);
}
