package com.umanav.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umanav.dojooverflow.models.Question;
import com.umanav.dojooverflow.services.AnswerService;
import com.umanav.dojooverflow.services.QuestionService;
import com.umanav.dojooverflow.services.TagService;

@Controller
public class QuestionController {
	//Service
	private final TagService tagServ;
	private final QuestionService questionServ;
	private final AnswerService answerServ;
	//Constructor
	public QuestionController(TagService tagServ, QuestionService questionServ, AnswerService answerServ) {
		this.tagServ = tagServ;
		this.questionServ = questionServ;
		this.answerServ = answerServ;
	}
	@RequestMapping("/questions")
	public String dashboard() {
		return "questions.jsp";
	}
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newquestion") Question question) {
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@Valid @ModelAttribute("newquestion") Question question, BindingResult result) {
		if (result.hasErrors()) {
            return "newQuestion.jsp";
        }else{
            return "newQuestion.jsp";
        }
	}


}
