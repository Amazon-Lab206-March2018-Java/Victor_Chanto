package com.umanav.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.dojo.models.Dojo;
import com.umanav.dojo.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	public DojoService (DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
		
	}
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	public Optional<Dojo> getDojo(Long id) {
		return dojoRepository.findById(id);
	}

}
