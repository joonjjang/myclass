package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServletContext con;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}
	
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		con = getServletContext();
		
		
		
		
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		
		String user_id = request.getParameter("user_id");
		ses.invalidate();
		
		
		List userList = (ArrayList) con.getAttribute("userList");
		userList.remove("user_id");
		
		for (int i = 0; i < userList.size(); i++) {
			out.println(userList.get(i)+ "<br>");
			
		}
		
		
		con.removeAttribute("userList");
		con.setAttribute("userList", userList);
		
		out.println("<br>로그아웃 완");
	
	
	}
	
	

}
