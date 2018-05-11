package com.umanav.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umanav.dojo.models.Ninja;
import com.umanav.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;
	public NinjaService (NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
		
	}
	public List<Ninja> getNinjas(Long id){
		return ninjaRepository.findBydojo_id(id);
	}
}
