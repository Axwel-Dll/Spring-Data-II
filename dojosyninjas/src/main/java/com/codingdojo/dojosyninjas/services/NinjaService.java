package com.codingdojo.dojosyninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.models.Ninja;
import com.codingdojo.dojosyninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public void create(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
}
