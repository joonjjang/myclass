package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


//@WebFilter(urlPatterns = "/*")
public class EncoderFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
		

	}


	public void destroy() {
		System.out.println("destroy 호출");
	}

}
