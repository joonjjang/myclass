package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletContext; //웹애플리케이션(pro10)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();

		System.out.println(context.getServletContextName());

		HttpSession ses = request.getSession();
		
		String ctm = (String) context.getAttribute("context");
		String stm = (String) ses.getAttribute("ses");
		String rtm = (String) request.getAttribute("request");

		System.out.println(ctm);
		System.out.println(stm);
		System.out.println(rtm);
	}

}
