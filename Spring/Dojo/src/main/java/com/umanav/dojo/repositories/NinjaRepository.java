package com.umanav.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umanav.dojo.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>  {
	List<Ninja> findBydojo_id(Long id);

}
