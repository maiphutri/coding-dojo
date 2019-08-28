package com.trimai.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.events.models.CourseUser;
import com.trimai.events.repositories.CourseUserRepo;

@Service
public class CourseUserService {
	@Autowired
	private CourseUserRepo cuR;
	
	public CourseUser createOrUpdate(CourseUser cU) {
		CourseUser newCU = new CourseUser();
		newCU.setCourse(cU.getCourse());
		newCU.setUser(cU.getUser());
		return cuR.save(newCU);
	}
	
	public List<CourseUser> findAllByCourseId(Long id) {
		return cuR.findAllByCourseId(id);
	}
	
	public CourseUser findByUserIdAndCouserId(Long userId, Long id) {
		Optional<CourseUser> cU = cuR.findByUserIdAndCourseId(userId, id);
		if (cU.isPresent()) {
			return cU.get();
		}
		return null;
	}
	
	public void removeById(Long id) {
		cuR.deleteById(id);
	}
}
