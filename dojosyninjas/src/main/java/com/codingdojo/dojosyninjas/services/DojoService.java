package com.codingdojo.dojosyninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.models.Dojo;
import com.codingdojo.dojosyninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojorepository;
	
	public DojoService(DojoRepository dojorepository) {
		this.dojorepository = dojorepository;
	}
	
	public void create(Dojo dojo) {
		dojorepository.save(dojo);
	}
	
	public List<Dojo> allDojos() {
		return dojorepository.findAll();
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojorepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}	
