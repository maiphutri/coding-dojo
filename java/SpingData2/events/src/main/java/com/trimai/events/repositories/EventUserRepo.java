package com.trimai.events.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.events.models.EventUser;

@Repository
public interface EventUserRepo extends CrudRepository<EventUser, Long>{
	Optional<EventUser> findByUserIdAndEventId(Long userId, Long eventId);
}
