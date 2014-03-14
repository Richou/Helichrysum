package net.heanoria.appengine.helichrysum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	public HomeController() {}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String doHome() {
		return "home";
	}
	
}
