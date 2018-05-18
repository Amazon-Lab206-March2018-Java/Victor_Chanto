package com.umanav.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.umanav.dojooverflow.models.Answer;
import com.umanav.dojooverflow.models.Question;
import com.umanav.dojooverflow.models.Tag;
import com.umanav.dojooverflow.services.AnswerService;
import com.umanav.dojooverflow.services.QuestionService;
import com.umanav.dojooverflow.services.TagService;

@Controller
public class AnswerController {
	//Service
	private final TagService tagServ;
	private final QuestionService questionServ;
	private final AnswerService answerServ;
	//Constructor
	public AnswerController(TagService tagServ, QuestionService questionServ, AnswerService answerServ) {
		this.tagServ = tagServ;
		this.questionServ = questionServ;
		this.answerServ = answerServ;
	}
	@PostMapping("/answer/add/{id}")
	public String addAnswer(@Valid @ModelAttribute("Answer") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			Question question = questionServ.findById(id).get();
			List <Tag> tags = tagServ.findByQues(questionServ.findById(id));
			model.addAttribute("ques", question);
			model.addAttribute("tags", tags);
			return "questionProfile.jsp";
	    }else{
	    	Question question = questionServ.findById(id).get();
	    	answer.setQuestion(question);
	    	answerServ.create(answer);
	    	return "redirect:/questions/"+question.getId();
	    }
	}

}
