package com.trimai.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.events.models.Course;
import com.trimai.events.repositories.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo cR;
	
	public Course createOrUpdate(Course course) {
		return cR.save(course);
	}
	
	public Course findById(Long id) {
		Optional<Course> c = cR.findById(id);
		if (c.isPresent()) {
			return c.get();
		}
		return null;
	}
	
	public List<Course> getAllCourses() {
		return cR.findAll();
	}
	
	public void delete(Long id) {
		cR.deleteById(id);
	}
	
}
