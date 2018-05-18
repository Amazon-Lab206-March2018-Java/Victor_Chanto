package com.umanav.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.umanav.dojooverflow.models.Question;
import com.umanav.dojooverflow.models.Tag;


public interface TagRepository extends CrudRepository<Tag, Long> {
	
	Tag findBySubject(String name);
	List<Tag> findAll();
	List<Tag> findByQuestions(Optional<Question> question);
}
