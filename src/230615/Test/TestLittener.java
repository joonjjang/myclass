package Test;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//@WebListener
public class TestLittener implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	
    public TestLittener() {
    	
    }
    
    public TestLittener(String user_id, String user_pw ) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }


    public void sessionCreated(HttpSessionEvent se)  { 
    	++total_user;
    	System.out.println(total_user);
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    	--total_user;
    	System.out.println(total_user);
    }
	
}
