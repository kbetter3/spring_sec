package com.spring.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		memberService.test();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info(user.toString());
		
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public  String registerPage() {
		return "register";
	}
}
