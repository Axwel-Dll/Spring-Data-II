package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long>{
	
	@Query("SELECT c,l FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' order by l.percentage desc")
	List<Object[]> query1();
	
	@Query("SELECT co.name, count(ci.id) total_ciudades FROM Country co JOIN co.cities ci GROUP BY co.name ORDER BY total_ciudades DESC")
	List<Object[]> query2();
	
    @Query("SELECT c,l FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> query4();
	
    @Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 AND c.population > 100000 ORDER BY c.surface_area")
    List<Object[]> query5();
    
    @Query("SELECT c.name, c.government_form, c.capital, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional monarchy' AND c.capital > 200 AND c.life_expectancy > 75 ORDER BY c.capital DESC")
    List<Object[]> query6();
    
    @Query("SELECT c.name AS CountryName, ci.name AS CityName, ci.district AS District, ci.population AS Population FROM Country c JOIN c.cities ci WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000")
    List<Object[]> query7();
    
    @Query("SELECT c.region, COUNT(c.id) AS numero_paises FROM Country c GROUP BY c.region ORDER BY numero_paises DESC")
    List<Object[]> query8();
	
}
	