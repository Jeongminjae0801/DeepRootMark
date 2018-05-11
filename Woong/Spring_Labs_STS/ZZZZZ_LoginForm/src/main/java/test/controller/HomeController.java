package test.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "main.home";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		
		return "joinus.login";
	}
	
}
