package com.trimai.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.relationships.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{
}
