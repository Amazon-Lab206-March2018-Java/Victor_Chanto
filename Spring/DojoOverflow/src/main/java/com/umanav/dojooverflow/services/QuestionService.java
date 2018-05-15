package com.umanav.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.umanav.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepo;
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
}
