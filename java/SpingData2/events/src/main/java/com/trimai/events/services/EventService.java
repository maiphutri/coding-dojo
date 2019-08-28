package com.trimai.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.events.models.Event;
import com.trimai.events.repositories.EventRepo;

@Service
public class EventService {
	@Autowired
	private EventRepo eR;
	
	public Event createOrUpdateEvent(Event event) {
		return eR.save(event);
	}
	
	public List<Event> findStateEvents(String state) {
		return eR.findAllByState(state);
	}
	
	public List<Event> findOtherEvents(String state) {
		return eR.findAllByStateIsNot(state);
	}
	
	public Event findById(Long id) {
		Optional<Event> e = eR.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteById(Long id) {
		eR.deleteById(id);
	}
}
