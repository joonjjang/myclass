<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    

    <%
    
    request.setAttribute("id", "홍");
    session.setAttribute("id1", "홍1");
    application.setAttribute("id2", "홍2");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:forward page="member4.jsp"></jsp:forward>



</body>
</html>