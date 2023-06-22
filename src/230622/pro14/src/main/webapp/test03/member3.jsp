<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- <jsp:useBean id = "m" class= "sec01.ex01.MemberBean ">

</jsp:useBean>

<jsp:useBean id = "ad" class= "sec01.ex01.Address ">

</jsp:useBean>

 --%>
<jsp:useBean id = "map" class= "java.util.HashMap" >
</jsp:useBean>



<%
map.put("id", "sadsad");
map.put("pwd", "asd");
map.put("email", "a");
map.put("name", "asd");

%>

<c:set var="a" value="${map }"></c:set>

<%-- <c:set var=" " value="" ></c:set>

<c:set var="memlist" value="${mlist }" >  </c:set>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${map }
${map.name }

${a.name }

</body>
</html>