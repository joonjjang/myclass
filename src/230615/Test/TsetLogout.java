package Test;

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
public class TsetLogout extends HttpServlet {
	List list = new ArrayList();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		
		ServletContext con = request.getServletContext();
		
		
		System.out.println(con);
		
		HttpSession ses =	request.getSession();
		
		String user_id = request.getParameter("user_id");
		
		System.out.println(user_id);
		
		System.out.println(ses);
		
		
		if(ses != null) {
			
			list.add(user_id);
			out.println("잘가요.<br>");
			out.println(user_id + "<br>");
			out.println("현재 접속자 수는 :" + TestLittener.total_user + "명입니다.<br>" );
			out.println("현재 접속 인원 <br>");
			for (int i = 0; i < list.size(); i++) {
				out.println(list.get(i)+ "<br>");
			}

		}
		
	}
}
