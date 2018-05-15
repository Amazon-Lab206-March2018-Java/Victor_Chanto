package com.umanav.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.umanav.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
