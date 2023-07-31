package com.codingdojo.dojosyninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosyninjas.models.Dojo;
import com.codingdojo.dojosyninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
//	private final DojoService dojoService;
//	
//	public DojoController(DojoService dojoService) {
//		this.dojoService = dojoService;
//	}
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("add") Dojo dojo) {
		return "/views/newdojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("add") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/newdojo.jsp";
		}
		else {
			dojoService.create(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/views/show.jsp";
	}
}
