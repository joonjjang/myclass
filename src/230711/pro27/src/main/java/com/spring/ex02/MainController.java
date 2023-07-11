package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main2")
public class MainController {

	@RequestMapping(value =  "/login3.do" , method = RequestMethod.GET  )
	public ModelAndView main(@ModelAttribute("user") LoginVO loginVO, HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("123");
		
		return new ModelAndView("login");
		
		
		
	
	}
	@RequestMapping(value =  "/login3.do" , method = RequestMethod.POST  )
	public ModelAndView main1(@ModelAttribute("user") LoginVO loginVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("로그인됨post");

		return new ModelAndView("main");
		
		
		
	
	}
	

	
	
}