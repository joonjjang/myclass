package sec05.ex01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		
		
		System.out.println("갑 저장함");
		
		List list = new ArrayList();
		list.add("ㅎㅇㅎㅇ");
		list.add("addas");
		
		ctx.setAttribute("k", list);
		
		
		
	}

	
}
