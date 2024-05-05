package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello(){
		ModelAndView mv=new ModelAndView();
		System.out.println("Hello controller");
		mv.setViewName("HELLO");
		mv.addObject("name","Vishavambhar");
		return mv;
	}

}
