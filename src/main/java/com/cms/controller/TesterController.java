package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TesterController {

	@RequestMapping(path="/", method = RequestMethod.GET)
	public String home(ModelMap map){
		return "index";
	}
	
	@RequestMapping(path="/index", method = RequestMethod.GET)
	public String index(ModelMap map){
		return "views/index1";
	}
	
}
