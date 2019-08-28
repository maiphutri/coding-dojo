package com.trimai.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.events.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{
	
}
