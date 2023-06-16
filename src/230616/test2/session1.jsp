<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String str = (String) application.getAttribute("food");

application.setAttribute("address", "미금역");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<%= str %>

<a href='/pro12/test1/session2.jsp'>두번째 페이지로 이동하기 </a>
</body>
</html>