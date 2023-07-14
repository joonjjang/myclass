package com.myspring.pro28.ex05;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class LocaleInterceptor extends  HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LocaleInterceptor.class);
	   @Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		    HttpSession session=request.getSession();
		    logger.info("여기도 온다 123321213123456");
		      String locale=request.getParameter("locale");
		      if(locale==null)
		         locale="ko";
		      session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE",new Locale(locale));
		      return true;
	   }

	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response,
	                           Object handler, ModelAndView modelAndView) throws Exception {
		   logger.info("여기서 마감~ 여기서 어디로?");
		   
	   }

	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
	                                    Object handler, Exception ex)    throws  Exception {
		   
		   
		   
		   logger.info("여기서 마감~ 여기서 어디로?12321321312");
	   }
	}
