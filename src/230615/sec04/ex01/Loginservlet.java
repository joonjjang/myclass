package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	
	List userList = new ArrayList();;
	ServletContext con = null ;

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");

		
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		

		
		con = getServletContext();
		
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			userList.add(user_id);
			con.setAttribute("userList", userList);
		}
		
		

		out.println("<head>");
		out.println("<script  type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");
		out.println("</script>");
		out.println("</head>");
		out.println("<html><body>");
		out.println("아이디는 " + user_id + "<br>");
		out.println("총 접속자수는" + LoginImpl.total_user + "<br>");
		
		List userList = (ArrayList) con.getAttribute("userList");
		
		for (int i = 0; i < userList.size(); i++) {
			out.println(userList.get(i)+ "<br>");
		}
		
		out.println("<a href='logout?user_id="+user_id+"'>로그아웄또!</a>");
		out.println("</body></html>");
		
		out.println("<a href='logout?user_id=" + user_id + "'>로그아웃 되셨습니다</a>");
	}

}
