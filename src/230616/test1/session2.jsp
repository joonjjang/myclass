<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String str = (String) session.getAttribute("food");

String address = (String) session.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= str %>
<%= address %>
<a href='https://map.naver.com/v5/search/%EC%9D%8C%EC%8B%9D%EC%A0%90/place/1283858281?c=17.5,0,0,0,dh'>미금국수(열무국수) </a>
</body>
</html>