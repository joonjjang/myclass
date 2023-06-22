<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id = "m" class= "sec01.ex01.MemberBean ">

</jsp:useBean>

<jsp:useBean id = "ad" class= "sec01.ex01.Address ">

</jsp:useBean>


<jsp:useBean id = "list" class= "java.util.ArrayList " >
</jsp:useBean>

<jsp:useBean id = "map" class= "java.util.HashMap " >
</jsp:useBean>



<%
MemberBean mem1 = new MemberBean("con", "123", "손흥민", "asdf");
list.add(mem1);

MemberBean mem2 = new MemberBean("conasd", "a123", "유흥민", "aㅁsdf");
list.add(mem2);

map.put("mlist", list);

%>

<c:set var=" " value="" ></c:set>

<c:set var="memlist" value="${mlist }" >  </c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${memlist[0].id }



</body>
</html>