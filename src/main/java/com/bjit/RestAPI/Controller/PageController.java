package com.bjit.RestAPI.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class PageController {
	
	@RequestMapping(value= "/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value= "/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickCreate", true);
		return mv;
	}

}
