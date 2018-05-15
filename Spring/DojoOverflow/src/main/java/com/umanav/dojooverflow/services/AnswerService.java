package com.umanav.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.umanav.dojooverflow.repositories.AnswerRepository;


@Service
public class AnswerService {
	private AnswerRepository answerRepo;
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}

}