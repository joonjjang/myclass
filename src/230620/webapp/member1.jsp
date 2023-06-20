<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%
String id = (String)request.getAttribute("id");
String pwd = (String)request.getAttribute("pwd");
String name = (String)request.getAttribute("name");
String email = (String)request.getAttribute("email");
%>
 --%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" />
<jsp:setProperty property="*" name="m" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table border=1 align="center">
		<tr bgcolor="red">
			<td width="20%">아이디</td>
			<td width="20%">비밀번호</td>
			<td width="20%">이름</td>
			<td width="20%">이메일</td>

		</tr>
		<tr>
			<td>${m.id }</td>
			<td>${m.pwd }</td>
			<td>${m.name }</td>
			<td>${m.email }</td>
			<td>${requestScope.address }</td>
		</tr>
	
	</table>
	
	${param } <br>
	${m }
	
</body>
</html>