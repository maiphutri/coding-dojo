package com.trimai.events.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.events.models.EventUser;
import com.trimai.events.repositories.EventUserRepo;

@Service
public class EventUserService {
	@Autowired
	private EventUserRepo euR;
	
	public EventUser createOrUpdate(EventUser eU) {
		return euR.save(eU);
	}
	
	public EventUser findByEventAndUser(Long eventId, Long userId) {
		Optional<EventUser> eU = euR.findByUserIdAndEventId(userId, eventId);
		if (eU.isPresent()) {
			return eU.get();
		}
		return null;
	}
	
	public void cancelEvent(Long id) {
		euR.deleteById(id);
	}
}
