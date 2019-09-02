package com.hanwha.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/redirecttest")
	public String test() {
		
		return "test3";
		//return "redirect:han";
	}
		
	@RequestMapping("/paramtest2")
	public ModelAndView paramtest2(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", user.getUserid());
		mv.addObject("username", "\""+user.getUsername()+"\"님");
		mv.setViewName("paramtestresult");
		return mv;
	}
	
	@RequestMapping("/paramtest")
	public ModelAndView paramtest(int userid, String username) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", userid);
		mv.addObject("username", "\""+username+"\"님");
		mv.setViewName("paramtestresult");
		return mv;
	}
	
	@RequestMapping("/han")
	public ModelAndView han () {
		ModelAndView mv = new ModelAndView();
		mv.addObject("company", "한화시스템 ICT");
		mv.addObject("dept", "개발");
		mv.addObject("myname", "성욱");
		mv.setViewName("test3");
		return mv;
	}
	

	@RequestMapping(value = "/test")
	public String test2 (Model model) {
		model.addAttribute("company", "한화시스템 ICT!");
		model.addAttribute("dept", "개발!");
		model.addAttribute("myname", "성욱!");
		return "test3";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "성욱");
		
		return "home";
	}
	
}
