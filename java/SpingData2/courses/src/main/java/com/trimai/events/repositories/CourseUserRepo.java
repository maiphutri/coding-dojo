package com.trimai.events.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.events.models.CourseUser;

@Repository
public interface CourseUserRepo extends CrudRepository<CourseUser, Long>{
	List<CourseUser> findAllByCourseId(Long id);
	Optional<CourseUser> findByUserIdAndCourseId(Long userId, Long id);
}
