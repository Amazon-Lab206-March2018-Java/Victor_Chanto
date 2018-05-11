package com.umanav.languagesreloaded.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.umanav.languagesreloaded.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();

}
