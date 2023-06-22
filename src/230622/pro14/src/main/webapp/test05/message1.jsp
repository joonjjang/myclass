<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:setLocale value="en_US"/>
<%-- <fmt:setLocale value="ko_KR"/> --%>

<h1>
<fmt:bundle basename="resource.member">
이름 : <fmt:message key="mem.name" />
주소 : <fmt:message key="mem.address" />
직업 : <fmt:message key="mem.job" />
</fmt:bundle>
</h1>


</body>
</html>