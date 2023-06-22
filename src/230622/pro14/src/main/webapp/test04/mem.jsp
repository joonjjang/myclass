<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

	request.setCharacterEncoding("utf-8");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="as" value="${param.id}" ></c:set>

	<c:if test="${empty as }">
	아이디를 입력해야지 이쉐키야!!</c:if>
	
	<c:if test="${not empty as }">
	<h1>환영합니다 ${as} 님!!</h1></c:if>
	
	<c:if test="${as == admin }">
	관리자구나 방갑다!
	</c:if>
	

</body>
</html>