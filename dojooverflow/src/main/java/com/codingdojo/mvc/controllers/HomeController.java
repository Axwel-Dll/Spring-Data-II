package com.codingdojo.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.services.ApiService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	ApiService apiService;

	@GetMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = apiService.allQuestions();
		model.addAttribute("questions", questions);
		return "/views/dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String addQuestion() {
		return "/views/newQuestion.jsp";
	}

	@PostMapping("/questions/new")
	public String createQuestion(@RequestParam("question") String question, @RequestParam("tags") String tags, Model model) {

	    if (question.length() < 1 || tags.trim().isEmpty()) {
	    	model.addAttribute("questionError", "La pregunta y tag no deben estar vacios.");
	    	return "/views/newQuestion.jsp";
	    }

	    Question newQuestion = new Question(question);

	    String[] tagsList = tags.split(",");
	    if (tagsList.length < 1 || tagsList.length > 3) {
	        model.addAttribute("tagsError", "Debe ingresar minimo 1 tag y maximo 3 tags.");
	        return "/views/newQuestion.jsp";
	    }

	    List<Tag> tagArray = new ArrayList<>();
	    for (String tag : tagsList) {
	        String trimmedTag = tag.trim();
	        if (!trimmedTag.isEmpty()) {
	            Tag newTag;
	            if (apiService.findTagBySubject(trimmedTag) == null) {
	                newTag = new Tag(trimmedTag);
	                apiService.saveTag(newTag);
	                newTag = apiService.findTagById(newTag.getId());
	            } else {
	                newTag = apiService.findTagBySubject(trimmedTag);
	            }
	            tagArray.add(newTag);
	        }
	    }
	    newQuestion.setTags(tagArray);
	    apiService.saveQuestion(newQuestion);
	    return "redirect:/questions";
	}

	
	@GetMapping("/questions/{questionId}")
	public String questionProfile(@ModelAttribute("addAnswer")Answer answer,@PathVariable("questionId")Long id,Model model) {
		model.addAttribute("question",apiService.findQuestionById(id));
		return"/views/showQuestion.jsp";
	}
	
	@PostMapping("/questions/{questionId}")
	public String addAnswerToQuestion(@Valid @ModelAttribute("addAnswer")Answer answer,BindingResult result,@PathVariable("questionId")Long id , Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question",apiService.findQuestionById(id));
			return"/views/showQuestion.jsp";
		}
		else {
			answer.setQuestion(apiService.findQuestionById(id));
			apiService.createAnswer(answer);
			return"redirect:/questions/"+id;
		}
	}


}

