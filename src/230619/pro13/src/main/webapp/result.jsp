<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   request.setCharacterEncoding("utf-8");
%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>결과창</title>
</head>
<body>
<%
   String userID = request.getParameter("userID" );
   if(userID.length()==0){
    /*
      RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");  
      dispatch.forward(request, response);
    */
%>
   <jsp:forward  page="login.jsp" /> //  forward문은 현재 요청을 다른 JSP 페이지나 서블릿으로 전달합니다. 이를 통해 페이지 간의 이동이 가능합니다.
<%	
  }
%>
  <h1>환영합니다   <%= userID %>님!! </h1>
</body>
</html>
