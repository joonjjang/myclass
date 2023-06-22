<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 	<c:if test="true">nice</c:if>
	
	<c:if test="false">nisec</c:if>
	 --%>
	 
<%-- 	<c:if test="true">참이네요
	<c:otherwise>이딴게 돼?</c:otherwise>
	</c:if> --%>
	
	
	<%-- <c:choose>
		<c:when test="true">참이네용</c:when>
		<c:otherwise>거짓말이네용</c:otherwise>
	</c:choose> --%>
	
	<%-- <c:set var="a" value="90" ></c:set>
	
	<c:choose>
		
		<c:when test="${100 < a }">100이하 점수 넣어라</c:when>
		<c:when test="${ 90 < a }"> A학점</c:when>
		<c:when test="${ 80 < a }"> B학좀</c:when>
		<c:when test="${ 70 < a }"> C학점</c:when>
		<c:when test="${ 60 < a }"> D학점</c:when>
		<c:otherwise>김기주</c:otherwise>
	</c:choose> --%>
	
<%-- 	<c:set var="name" value="asdsa" ></c:set>
	
	
	<c:choose>
		<c:when test="${empty name}">
		<tr >
		<td>
		이름입력
		</td>
		</tr>
		</c:when>
		<c:otherwise>
		<tr>
		<td>
		${name }
		</td>
		</tr>
		
		
		</c:otherwise>
	
	</c:choose> --%>
	
	<c:forEach begin="1" end="20 " var="i" step="2"> ${i } </c:forEach>
	
	<c:forEach begin="1" end="20 " var="i" step="2" varStatus="sad">${i }</c:forEach>




</body>
</html>