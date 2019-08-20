package com.trimai.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.countries.models.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
}
