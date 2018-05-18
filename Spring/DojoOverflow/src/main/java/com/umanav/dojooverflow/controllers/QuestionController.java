package com.umanav.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umanav.dojooverflow.models.Answer;
import com.umanav.dojooverflow.models.Question;
import com.umanav.dojooverflow.models.Tag;
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
	public String dashboard(Model m) {
		List<Question> questions = questionServ.allQuestions();
		m.addAttribute("questions", questions);
		return "questions.jsp";
	}
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newquestion") Question question) {
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@Valid @ModelAttribute("newquestion") Question question, BindingResult result,
			@RequestParam(value = "tagsGiven", required=false) String tagsGiven
			) {
		String[] tagsList = tagsGiven.split(","); //Splits the input in an array
		List<String> tagsAdded = new ArrayList<String>(Arrays.asList(tagsList)); // converts the array to a list
		if (result.hasErrors() || tagsAdded.size()>3) {
			if(tagsAdded.size()>3) {
				ObjectError error = new ObjectError("tagsGivenMore", "Must be less than 3 tags");
				result.addError(error);
			}
            return "newQuestion.jsp";
        }
		Question questiontoAdd = questionServ.add(question);
		List<Tag> tags = new ArrayList<Tag>();
		for (int x = 0; x<tagsAdded.size(); x++) { //iterates through the list of the inserted tags
			if(tagServ.findTag(tagsAdded.get(x)) == null){ //compares if the tag is already in the db
				tagServ.newTag(tagsAdded.get(x)); // if not in DB, adds the tag
				tags.add(tagServ.findTag(tagsAdded.get(x))); // adds to the list that we will link to the question
			}else {
				tags.add(tagServ.findTag(tagsAdded.get(x)));
			}
		}
		questiontoAdd.setTags(tags);
		questionServ.add(questiontoAdd);
		return "redirect:/questions";
	}
	@RequestMapping("/questions/{id}")
	public String viewQuestion(@ModelAttribute("Answer") Answer answer, @PathVariable("id") Long id, Model model) {
		Question question = questionServ.findById(id).get();
		List <Tag> tags = tagServ.findByQues(questionServ.findById(id));
		model.addAttribute("ques", question);
		model.addAttribute("tags", tags);
		return "questionProfile.jsp";
		
	}
}