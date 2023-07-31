package com.codingdojo.dojosyninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosyninjas.models.Ninja;
import com.codingdojo.dojosyninjas.services.DojoService;
import com.codingdojo.dojosyninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("add") Ninja Ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "/views/newninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("add") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/newninja.jsp";
		}
		else {
			ninjaService.create(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
}
