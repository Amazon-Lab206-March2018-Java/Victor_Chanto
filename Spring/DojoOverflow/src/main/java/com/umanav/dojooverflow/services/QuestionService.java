package com.umanav.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.dojooverflow.models.Question;
import com.umanav.dojooverflow.repositories.QuestionRepository;


@Service
public class QuestionService {
	private QuestionRepository questionRepo;
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	public Question add(Question question) {
		return questionRepo.save(question);
	}
	public List<Question> allQuestions() {
		return questionRepo.findAll();
	}
	
	public Optional<Question> findById(Long id) {
		return questionRepo.findById(id);
	}
}
