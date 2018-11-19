package com.spring.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.study.bean.Member;
import com.spring.study.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value={"/", "/info"}, method=RequestMethod.GET)
	public String home(Model model) {
		Member member = memberService.loadUserByUsername((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		model.addAttribute("member", member);
		
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(@RequestParam(value="error", required=false) String error, Model model) {
		model.addAttribute("error", error);

		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerProc(@ModelAttribute("member") Member member) {
		logger.info("register - post : " + member);
		memberService.registerMember(member);
		
		return "redirect:/login";
	}
	
//	@RequestMapping(value="/admin", method=RequestMethod.GET)
//	public String managePage(Model model) {
//		return "admin/userlist";
//	}
}
