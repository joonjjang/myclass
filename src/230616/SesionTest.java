package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess")
public class SesionTest extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		HttpSession ses = request.getSession();
		
		ses.setAttribute("food", "열무국수");
		
		pw.println("<html><body>");
		pw.println("<h1>세션에 이름을 바인딩합니다.</h1>");
		pw.println("<a href='/pro12/test1/session1.jsp'>첫번째 페이지로 이동하기 </a>");
		pw.println("</body></html>"); 
		
		
		
		
	}
	

}
