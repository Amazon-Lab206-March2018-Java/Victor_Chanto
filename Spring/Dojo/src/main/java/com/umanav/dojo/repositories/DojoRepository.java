package com.umanav.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umanav.dojo.models.Dojo;


public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

}
