package com.spring.ex01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/test")
public class MainController {

//	@RequestMapping("/main1.do")
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("jiji");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	
	}
	
//	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginpost(@RequestParam Map<String, String> map,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("post 로긴이여");
		ModelAndView mav = new ModelAndView();	

		
		mav.addObject("map", map);

		
		mav.setViewName("main");
		return mav;
	}
//	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
//	public ModelAndView loginpost(@RequestParam Map<String, String> map,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("post 로긴이여");
//		ModelAndView mav = new ModelAndView();	
//		
////		String id = request.getParameter("userID");
////		String name = request.getParameter("userName");
////		
//		String id =  map.get("userID");
//		
//		mav.addObject("userID", id);
//		
//		
//		mav.setViewName("main");
//		return mav;
//	}
	
//	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
//	public ModelAndView loginpost(@RequestParam (value = "userID")String userID ,@RequestParam String  userName,@RequestParam String email ,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("post 로긴이여");
//		ModelAndView mav = new ModelAndView();	
//		
////		String id = request.getParameter("userID");
////		String name = request.getParameter("userName");
////		
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//		mav.addObject("email", email);
//		
//		
//		mav.setViewName("main");
//		return mav;
//	}
	
//	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로긴이여");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	
}