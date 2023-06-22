<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%-- <c:set var="id" value="hong"></c:set>
<c:set var="num" value="${5 }"></c:set>
<c:set var="str" value="${num + num + num}"></c:set> --%>

<%-- <c:set var="m" value="memberForm.jsp"></c:set>
 --%>
<c:set var="cp" value=" ${pageContext.request.contextPath }/memberForm.html"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- ${id }
${num }
${str } --%>
<%-- 
 ${pageContext.request.contextPath }
 --%> 
 
<!-- <a href="memberForm.jsp">회원가입하기</a>
 --><a href="${cp }">회원가입하기</a>
 

</body>
</html>