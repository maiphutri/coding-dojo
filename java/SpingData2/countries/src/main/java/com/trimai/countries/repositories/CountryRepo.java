package com.trimai.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.countries.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage DESC")
	List<Object[]> joinCountryAndLanguage(String language);
	
	@Query("SELECT co.name, COUNT(ci) FROM Country co JOIN co.cities ci GROUP BY co.name")
	List<Object[]> displayTotalCitites();
	
	@Query("SELECT ci.name, ci.population FROM Country co JOIN co.cities ci WHERE co.name = ?1 AND ci.population > ?2 ORDER BY ci.population DESC")
	List<Object[]> getMexicoCities(String name, int population);
	
	@Query("SELECT co.name, l.percentage FROM Country co JOIN co.languages l WHERE l.percentage > ?1 ORDER BY l.percentage DESC")
	List<Object[]> getLanguage89(double percentage);
	
	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE surfaceArea < 501 AND population > 100000")
	List<Object[]> getSurfaceAreaAndPopulation();
	
	@Query("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy FROM Country c WHERE governmentForm = ?1 AND surfaceArea > 200 AND lifeExpectancy > 75")
	List<Object[]> sixTask(String governmentForm);
	
	@Query("SELECT co.name, ci.name, ci.district, ci.population FROM Country co JOIN co.cities ci WHERE co.name = ?1 AND ci.district = ?2 AND ci.population > 500000")
	List<Object[]> sevenTask(String name, String district);
	
	@Query("SELECT c.region, COUNT(c.region) AS countries FROM Country c GROUP BY c.region ORDER BY countries DESC")
	List<Object[]> finalTask();
}
