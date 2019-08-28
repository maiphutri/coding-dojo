package com.trimai.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.events.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{
	List<Message> findAllByEventId(Long id);
}
