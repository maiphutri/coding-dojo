package com.trimai.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.events.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAllByState(String state);
	List<Event> findAllByStateIsNot(String state);
}
