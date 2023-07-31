package com.codingdojo.licencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.licencia.models.License;
import com.codingdojo.licencia.models.Person;
import com.codingdojo.licencia.services.LicenseService;
import com.codingdojo.licencia.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class LicenseController {
	private final LicenseService licenseService;

	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	@Autowired
	private PersonService personService;

	@RequestMapping("/licenses/new")
	public String newLicense(Model model, @Valid @ModelAttribute("license") License license) {
		List<Person> persons = personService.obtenerPersonasSinLicencia();
		model.addAttribute("persons", persons);
		return "/views/newLicense.jsp";
	}

	@RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newLicense.jsp";
		} else {
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
			licenseService.create(license);
			return "redirect:/persons/" + license.getId();
		}

	}

}
