<%@page import="sec02.ex01.MemberBean"%>
<%@page import="sec02.ex01.MemberDAO"%>

<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="member" class="sec02.ex01.MemberBean" />
<jsp:setProperty property="*" name="member" />

<%
MemberDAO dao = new MemberDAO();
List<MemberBean> memberList = dao.listMembers();
dao.addMember(member);
request.setAttribute("memberList", memberList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:forward page="memberList.jsp"></jsp:forward>
</body>
</html>