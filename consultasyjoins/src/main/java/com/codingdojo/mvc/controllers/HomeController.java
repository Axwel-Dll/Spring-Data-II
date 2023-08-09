package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.mvc.models.City;
import com.codingdojo.mvc.services.ApiService;

@Controller
public class HomeController {
	@Autowired
	ApiService apiService;
	
	@GetMapping("/")
	public String obtenerQuery1(Model model) {
		List<Object[]> table = apiService.query1();
		model.addAttribute("table", table);
		return "/views/query1.jsp";
	}
	@GetMapping("/query2")
	public String obtenerQuery2(Model model) {
		List<Object[]> table = apiService.query2();
		model.addAttribute("table", table);
		return "/views/query2.jsp";
	}
	
	@GetMapping("/query3")
	public String obtenerQuery3(Model model) {
		List<City> table = apiService.query3();
		model.addAttribute("table", table);
		return "/views/query3.jsp";
	}
	
	@GetMapping("/query4")
	public String obtenerQuery4(Model model) {
		List<Object[]> table = apiService.query4();
		model.addAttribute("table", table);
		return "/views/query4.jsp";
	}
	
	@GetMapping("/query5")
	public String obtenerQuery5(Model model) {
		List<Object[]> table = apiService.query5();
		model.addAttribute("table", table);
		return "/views/query5.jsp";
	}
	
	@GetMapping("/query6")
	public String obtenerQuery6(Model model) {
		List<Object[]> table = apiService.query6();
		model.addAttribute("table", table);
		return "/views/query6.jsp";
	}
	
	@GetMapping("/query7")
	public String obtenerQuery7(Model model) {
		List<Object[]> table = apiService.query7();
		model.addAttribute("table", table);
		return "/views/query7.jsp";
	}
	
	@GetMapping("/query8")
	public String obtenerQuery8(Model model) {
		List<Object[]> table = apiService.query8();
		model.addAttribute("table", table);
		return "/views/query8.jsp";
	}

}
