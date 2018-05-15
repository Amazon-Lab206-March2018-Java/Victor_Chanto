package com.umanav.dojooverflow.controllers;

import org.springframework.stereotype.Controller;

import com.umanav.dojooverflow.services.AnswerService;
import com.umanav.dojooverflow.services.QuestionService;
import com.umanav.dojooverflow.services.TagService;

@Controller
public class TagController {
	//Service
	private final TagService tagServ;
	private final QuestionService questionServ;
	private final AnswerService answerServ;
	//Constructor
	public TagController(TagService tagServ, QuestionService questionServ, AnswerService answerServ) {
		this.tagServ = tagServ;
		this.questionServ = questionServ;
		this.answerServ = answerServ;
	}

}
