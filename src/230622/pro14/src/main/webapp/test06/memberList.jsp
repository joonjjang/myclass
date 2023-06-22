<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

memberList
 <table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	    <td width="7%" >아이디</td>
	    <td width="7%">비밀번호</td>
	    <td width="5%" >이름</td>
	    <td width="11%" >이메일</td>
	</tr>
	
	
	<c:choose>
		<c:when test="${memberList == null }">
			<tr>
			
			<td colspan="5">등록된 회원 없습니다. </td>
			
			</tr>
		
		</c:when>
		<c:otherwise >
			<c:forEach var="member" items="${memberList }">
			<tr align="center">		
			<td>${member.id } </td>
			<td>${member.pwd } </td>
			<td>${member.email } </td>
			<td>${member.name } </td>
			<td>${member.joindate } </td>
			
			</tr>
			</c:forEach>
		</c:otherwise>
		
	</c:choose>
 </table>
</body>
</html>