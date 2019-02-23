package com.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/customer")
public class CustomerControler {
	

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage() {
		return "Dashboard";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView modelAndView=new ModelAndView("home");		
		modelAndView.addObject("name",username);
		return modelAndView;
	}
	

	@RequestMapping(value="/settings", method = RequestMethod.GET)
	public ModelAndView findCustomerResult() {		
		ModelAndView modelAndView=new ModelAndView("Settings");		
		return modelAndView;
	}
	
	@RequestMapping(value="/apps", method = RequestMethod.GET)
	public ModelAndView displayCreateCustomer() {
		ModelAndView modelAndView=new ModelAndView("Apps");
		return modelAndView;
	}
	
	
	
}