package com.codingdojo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.services.UserService;
import com.codingdojo.mvc.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/views/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/views/loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
		if(result.hasErrors()) {
	        return "/views/registrationPage.jsp";
		}
		else {
			userService.registerUser(user);
			return "redirect:/home";
		}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            User user = userService.findByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "/views/loginPage.jsp";
        }
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            User user = userService.findUserById(userId);
            model.addAttribute("user", user);
            return "/views/homePage.jsp";
        } else {
            return "redirect:/login";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
}
