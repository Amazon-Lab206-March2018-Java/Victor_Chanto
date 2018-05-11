package com.umanav.license.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.umanav.license.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
	Optional<License> findByperson_id(Long id);
	Optional<License> findFirstByOrderByIdDesc();

}
