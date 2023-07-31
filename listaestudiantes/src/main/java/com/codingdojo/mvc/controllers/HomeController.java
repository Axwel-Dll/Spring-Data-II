package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Contact;
import com.codingdojo.mvc.models.Student;
import com.codingdojo.mvc.services.ApiService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	ApiService apiService;

	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}

	@RequestMapping("/students")
	public String show(Model model) {
		List<Student> students = apiService.allStudent();
		model.addAttribute("students", students);
		return "/views/show.jsp";
	}

	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("addstudent") Student student, Model model) {
		return "/views/newStudent.jsp";
	}

	@RequestMapping(value = "/students/new", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("addstudent") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newStudent.jsp";
		} else {
			apiService.createStudent(student);
			return "redirect:/students";
		}
	}

	// metodo para crear por url: /students/create?firstName=John&lastName=Doe&age=35
	@RequestMapping("/students/create")
	public String createStudent(Student student) {
		apiService.createStudent(student);
		return "redirect:/students";
	}

	@RequestMapping("/contact/new")
	public String newContact(Model model, @Valid @ModelAttribute("addcontact") Contact contact) {
		List<Student> students = apiService.getStudentsWithoutContact();
		model.addAttribute("students", students);
		return "/views/newContact.jsp";
	}

	@RequestMapping(value = "/contact/new", method = RequestMethod.POST)
	public String addContact(@Valid @ModelAttribute("addcontact") Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newContact.jsp";
		} else {
			apiService.createContact(contact);
			return "redirect:/students";
		}
	}

	// metodo para crear por url: /contacts/create?student=1&address=1234%20Some%20Street&city=Los%20Angeles&state=CA
	@RequestMapping("/contacts/create")
	public String createContact(Contact newContact, @RequestParam("student") Long studentId) {
		Student student = apiService.findStudent(studentId);
		if (student != null) {
			newContact.setStudent(student);
			apiService.createContact(newContact);
		}

		return "redirect:/students";
	}
}
