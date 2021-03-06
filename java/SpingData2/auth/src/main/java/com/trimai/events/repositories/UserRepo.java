package com.trimai.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.events.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
