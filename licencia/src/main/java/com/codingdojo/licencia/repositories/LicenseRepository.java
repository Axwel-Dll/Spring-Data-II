package com.codingdojo.licencia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.licencia.models.License;

public interface LicenseRepository extends CrudRepository <License, Long>{
	List<License> findAll();
	List<License> findTopByOrderByNumberDesc();
}
