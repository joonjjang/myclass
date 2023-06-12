package sec05.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		
//		String at= (String) ctx.getAttribute("k");
		
		List list= (List) ctx.getAttribute("k");
		
		
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}
