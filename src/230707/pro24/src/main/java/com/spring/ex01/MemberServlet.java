package com.spring.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		String action = request.getParameter("action");
		System.out.println(action);
		String nextPage = "";
		MemberVO memberVO = new MemberVO();
		
		if (action == null || action.equals("listMembers")) {
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			
			nextPage = "test01/listMembers.jsp";
			
		} else if(action.equals("addMember")) {
			System.out.println("회원 추가");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			System.out.println(id + pwd + name + email);
			
			memberVO.setId(id);
			memberVO.setName(name);
			memberVO.setPwd(pwd);
			memberVO.setEmail(email);
			
			dao.addMember(memberVO);
			nextPage = "/mem.do?action=listMembers";

		} else if(action.equals("delMember")) {
			
			String id = request.getParameter("id");
			
			memberVO.setId(id);
			dao.delMember(memberVO);
			nextPage = "/mem.do?action=listMembers";
		
		} else if(action.equals("saerchMember")) {
			
			System.out.println("서치 입장불가");
			String name = request.getParameter("value");
		
			System.out.println(name);
			memberVO.setName(name);
			List<MemberVO> membersList = dao.saerchMember(memberVO);
			request.setAttribute("membersList", membersList);
			
			nextPage = "/test01/listMembers.jsp";
			
		} else if(action.equals("saerchMember2")) {
			
			System.out.println("서치 입장불가");
			String email = request.getParameter("value");
		
			System.out.println(email);
			memberVO.setEmail(email);
			List<MemberVO> membersList = dao.saerchMember2(memberVO);
			request.setAttribute("membersList", membersList);
			
			nextPage = "/test01/listMembers.jsp";
			
		} else if(action.equals("modMember")) {
			
			System.out.println("수정입장");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			System.out.println(id + pwd + name + email);
			
			memberVO.setId(id);
			memberVO.setName(name);
			memberVO.setPwd(pwd);
			memberVO.setEmail(email);
			

			dao.modMember(memberVO);
			
			
			nextPage = "/mem.do?action=listMembers";
		}	else if(action.equals("selectAllMember")) {
			
			nextPage = "/mem.do?action=listMembers";
		}
			
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	 
	
	} 
}
