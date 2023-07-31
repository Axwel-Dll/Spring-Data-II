package com.codingdojo.licencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.licencia.models.Person;
import com.codingdojo.licencia.services.LicenseService;
import com.codingdojo.licencia.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class PersonController {
	private final PersonService personService;
	private final LicenseService licenseService;

	public PersonController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}

	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("addperson") Person person, Model model) {
		return "/views/newPerson.jsp";
	}

	@RequestMapping(value = "/persons/new", method = RequestMethod.POST)
	public String addperson(@Valid @ModelAttribute("addperson") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newPerson.jsp";
		} else {
			personService.create(person);
			return "redirect:/licenses/new";
		}
	}

	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("license", licenseService.getLicense(id).get());
		return "/views/display.jsp";
	}
}
