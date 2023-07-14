package com.myspring.pro27.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView delMember(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView addMember(MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView modMember(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView updateMember(MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView searchMember(String action, String value, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView login(MemberVO member, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
