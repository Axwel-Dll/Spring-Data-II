package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.City;

@Repository
public interface CityRepository extends CrudRepository<City,Long>{
	
	@Query("SELECT ci FROM Country co JOIN co.cities ci WHERE co.id=136 and ci.population > 500000 ORDER BY ci.population DESC")
	List<City> query3();
}
