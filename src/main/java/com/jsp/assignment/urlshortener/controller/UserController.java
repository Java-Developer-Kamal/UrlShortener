package com.jsp.assignment.urlshortener.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.assignment.urlshortener.entity.User;
import com.jsp.assignment.urlshortener.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveUser(User user) {
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpSession httpSession, @RequestParam String email,
			@RequestParam String password) {
		return userService.loginUser(httpSession, email, password);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutUser(HttpSession httpSession) {
		return userService.logoutUser(httpSession);
	}
	
	

}
