package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String ctm ="컨텍스트 바인딩 됨";
		String stm ="세션 바인딩 됨";
		String rtm ="리퀘스트 바인딩 됨";
		
		
		ServletContext context =  getServletContext()	;
		
		HttpSession  ses = request.getSession();
		
		context.setAttribute("context", ctm);
		ses.setAttribute("ses", stm);
		request.setAttribute("request", rtm);
		System.out.println("바인딩 됌");
	}

}
